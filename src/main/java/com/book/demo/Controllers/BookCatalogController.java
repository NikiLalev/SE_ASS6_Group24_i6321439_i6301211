package com.book.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.demo.Model.Book;
import com.book.demo.Services.BookCatalogService;

@RestController
@RequestMapping("/catalog")
public class BookCatalogController {

    @Autowired
    BookCatalogService bookCatalogService;

    @GetMapping("/test")
    public String hello() {
        return "test";
    }
    
    @GetMapping("/book/{id}")
    public Book getByID(@PathVariable("id") int id) {
        Book book = bookCatalogService.getByID(id);
        return book;
    }

   @PostMapping("/book")
   public Book createBook(@RequestBody Book book){
        bookCatalogService.addBook(book);
        return book;
   }
}
