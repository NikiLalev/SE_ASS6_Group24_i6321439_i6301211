package com.book.demo.BookInventoryMicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class BookInventoryController {
 
    @Autowired
    BookInventoryService bookInventoryService;

    @GetMapping("/book/{id}")
    public int getQuantityByID(@PathVariable("id") int id) {
        int quantity = bookInventoryService.getQuantityByID(id);
        return quantity;
    }

    @PostMapping("/book/{id}")
    public void setQuantityByID(@RequestBody int quantity, @PathVariable("id") int id) {
        bookInventoryService.setQuantityByID(id, quantity);
    }

    @PutMapping("/book/{id}")
    public void updateQuantityByID(@RequestBody int quantity, @PathVariable("id") int id) {
        bookInventoryService.updateQuantityByID(id, quantity);
    }



    
}
