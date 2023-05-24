package com.book.demo.BookControllers;

import com.book.demo.BookModel.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class BookCatalogController {

    Book book;
    
   @GetMapping("/book/{id}")
   public Book getByID(int id){
    return new Book(1, "Harry Potter" , "G.Padure", 2001 ,1);
   }

   @PostMapping("/book")
   public Book createBook(@RequestBody Book book){
    this.book = book;
    return book;
   }



}
