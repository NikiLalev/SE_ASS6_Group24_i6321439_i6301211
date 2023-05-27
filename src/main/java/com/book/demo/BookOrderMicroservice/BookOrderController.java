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

    private final WebClient webClient;

    @Autowired
    BookOrderServiceImpl bookOrderService;

    public BookOrderController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
   }
    
    @PostMapping("/book")
    public void addOrderBookID(@RequestBody ObjectNode json) {
        int bookId = json.get("bookId").asInt();
        int quantity = json.get("quantity").asInt();

        Order order = new Order(bookId, quantity);

        ResponseEntity<String> responseGetBook = 
          webClient.get()
          .uri("/catalog/book/{id}", order.getBookId())
          .retrieve()
          .toEntity(String.class)
          .block();
        
        ResponseEntity<Integer> responseGetQuantity = 
          webClient.get()
          .uri("/inventory/book/{id}", order.getBookId())
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
                .uri("/inventory/book/{id}", bookId)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(-quantity))
                .retrieve()
                .toEntity(String.class)
                .block();
        } else {
            System.out.println("Couldn't place order, please try again later");
        }
    }
}
