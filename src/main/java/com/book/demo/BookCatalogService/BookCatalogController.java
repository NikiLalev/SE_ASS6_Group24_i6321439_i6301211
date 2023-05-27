package com.book.demo.BookCatalogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.demo.BookInventoryService.BookInventoryService;

@RestController
@RequestMapping("/catalog")
public class BookCatalogController {

    @Autowired
    BookCatalogServiceImpl bookCatalogService;
    @Autowired
    BookInventoryService bookInventoryService;
    
    @GetMapping("/book/{id}")
    public Book getBookByID(@PathVariable("id") int id) {
        Book book = bookCatalogService.getByID(id);
        return book;
    }

   @PostMapping("/book/{quantity}")
   public Book createBook(@RequestBody Book book, @PathVariable("quantity") int quantity) {
        bookCatalogService.addBook(book);
        bookInventoryService.setQuantityByID(book.getId(), quantity); //call through port POST http://localhost:8080/inventory/book/{id} body - quantity
        return book;
   }


   @PutMapping("/book/{id}")
   public Book updateBook(@RequestBody Book book, @PathVariable("id") int id) {
        bookCatalogService.updateBook(book, id);
        return book;
   }

   @DeleteMapping("/book/{id}")
   public void deleteBook(@PathVariable("id") int id) {
        bookCatalogService.deleteBook(id); 
   }
}
