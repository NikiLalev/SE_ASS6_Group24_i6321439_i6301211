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

import com.book.demo.BookInventoryService.BookInvetoryService;

@RestController
@RequestMapping("/catalog")
public class BookCatalogController {

    @Autowired
    BookCatalogService bookCatalogService;
    @Autowired
    BookInvetoryService bookInvetoryService;
    
    @GetMapping("/book/{id}")
    public Book getBookByID(@PathVariable("id") int id) {
        Book book = bookCatalogService.getByID(id);
        return book;
    }

   @PostMapping("/book/{quantity}")
   public Book createBook(@RequestBody Book book, @PathVariable("quantity") int quantity){
        bookCatalogService.addBook(book);
        bookInvetoryService.setQuantityByID(book.getId(), quantity);
        return book;
   }

   @PutMapping("/book/{id}")
   public Book updateBook(@RequestBody Book book){
    //this.book = book;
    return book;
   }

   @DeleteMapping("/book/{id}")
   public void deleteBook(@PathVariable("id") int id){
    //this.book = book;
     bookCatalogService.deleteBook(id);
   }
}
