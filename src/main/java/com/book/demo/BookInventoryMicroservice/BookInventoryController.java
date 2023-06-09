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
    BookInventoryServiceImpl bookInventoryService;

    @GetMapping("/book/{id}")
    public int getQuantityByID(@PathVariable("id") int id) {
        int quantity = bookInventoryService.getQuantityById(id);
        return quantity;
    }

    @PostMapping("/book/{id}")
    public boolean setQuantityByID(@RequestBody int quantity, @PathVariable("id") int id) {
        return bookInventoryService.setQuantityById(id, quantity);
    }

    @PutMapping("/book/{id}")
    public boolean updateQuantityByID(@RequestBody int quantity, @PathVariable("id") int id) {
        return bookInventoryService.updateQuantityById(id, quantity);
    }



    
}
