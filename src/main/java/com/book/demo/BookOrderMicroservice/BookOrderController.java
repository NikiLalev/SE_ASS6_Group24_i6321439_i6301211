package com.book.demo.BookOrderMicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class BookOrderController {
    @Autowired
    BookOrderService bookOrderService;
    
    @PostMapping("/book")
    public void addOrderBookID(@RequestBody Order order) {
        bookOrderService.sendOrder(order);
        //update quantity through book inventory
    }
}
