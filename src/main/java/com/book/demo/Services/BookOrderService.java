package com.book.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.demo.Model.Order;

@Service
public class BookOrderService {
    private List<Order> orderList;

    @Autowired
    BookCatalogService bookCatalogService;
    BookInvetoryService bookInvetoryService;

    public void sendOrder(Order order) {
        if(bookCatalogService.getByID(order.getBookId()) != null &&
            bookInvetoryService.getQuantityByID(order.getBookId()) <= order.getQuantity()) {
                orderList.add(order);
           }    
    }
}
