package com.book.demo.BookOrderMicroservice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.demo.BookCatalogMicroservice.BookCatalogServiceImpl;
import com.book.demo.BookInventoryMicroservice.BookInventoryServiceImpl;

@Service
public class BookOrderService {
    private List<Order> orderList;

    @Autowired
    BookCatalogServiceImpl bookCatalogService;
    BookInventoryServiceImpl bookInvetoryService;

    public void sendOrder(Order order) {
        if(bookCatalogService.getById(order.getBookId()) != null &&
            bookInvetoryService.getQuantityById(order.getBookId()) <= order.getQuantity()) {
                orderList.add(order);
           }    
    }
}
