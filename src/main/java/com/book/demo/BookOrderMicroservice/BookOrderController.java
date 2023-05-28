package com.book.demo.BookOrderMicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/order")
public class BookOrderController {

    @Autowired
    BookOrderServiceImpl bookOrderService;
    
    @PostMapping("/book")
    public boolean addOrderByBookId(@RequestBody ObjectNode json) {
        int bookId = json.get("bookId").asInt();
        int quantity = json.get("quantity").asInt();

        Order order = new Order(bookId, quantity);
        String ctalogUrl = "http://localhost:8080/catalog/book/" + bookId;
        String inventoryUrl = "http://localhost:8080/inventory/book/" + bookId;
        WebClient webClient = WebClient.create();

        ResponseEntity<String> responseGetBook = 
          webClient.get()
          .uri(ctalogUrl)
          .retrieve()
          .toEntity(String.class)
          .block();
        
        ResponseEntity<Integer> responseGetQuantity = 
          webClient.get()
          .uri(inventoryUrl)
          .retrieve()
          .toEntity(Integer.class)
          .block();

        //ensure that the book with the corresponding id is present and we have the needed quantity
        if(responseGetBook.getBody() != null 
        && responseGetQuantity.getStatusCode().is2xxSuccessful() 
        && quantity <= responseGetQuantity.getBody()) {
            bookOrderService.sendOrder(order);

            //update the quantity of the book
            webClient.put()
                .uri(inventoryUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(-quantity))
                .retrieve()
                .toEntity(String.class)
                .block();

            return true;
        } else {
            System.out.println("Couldn't place order, please try again later");
            return false;
        }
    }
}
