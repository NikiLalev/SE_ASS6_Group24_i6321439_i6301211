package com.book.demo.BookCatalogMicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;


import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/catalog")
public class BookCatalogController {

     private final WebClient webClient;

    @Autowired
    BookCatalogServiceImpl bookCatalogService;

    public BookCatalogController(WebClient.Builder webClientBuilder) {
         this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }
    
    @GetMapping("/book/{id}")
    public Book getBookByID(@PathVariable("id") int id) {
        Book book = bookCatalogService.getById(id);
        return book;
    }

    /**
     * Post mapping for adding a book to the catalog of books
     * @param json 
     * @return
     */
   @PostMapping("/book")
   public Book createBook(@RequestBody ObjectNode json) {
     String title = json.get("title").asText();
     String author = json.get("author").asText();
     int publicationYear = json.get("publicationYear").asInt();
     int quantity = json.get("quantity").asInt();
     Book book = new Book(title, author, publicationYear);
     bookCatalogService.addBook(book);
     //bookInventoryService.setQuantityByID(book.getId(), quantity); //call through port POST http://localhost:8080/inventory/book/{id} body - quantity
     ResponseEntity<String> response = 
          webClient.post()
          .uri("/inventory/book/{id}", book.getId())
          .contentType(MediaType.APPLICATION_JSON)
          .body(BodyInserters.fromValue(quantity))
          .retrieve()
          .toEntity(String.class)
          .block();
     return book;
   }

   @PutMapping("/book/{id}")
   public Book updateBook(@RequestBody Book book, @PathVariable("id") int id) {
        if(bookCatalogService.updateBook(book, id)) {
          return book;
        } 
        return book;

     //    else {
     //      throw new IllegalArgumentException("Please try again");
     //    }
   }

   @DeleteMapping("/book/{id}")
   public void deleteBook(@PathVariable("id") int id) {
        bookCatalogService.deleteBook(id); 
   }
}
