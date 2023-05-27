package com.book.demo.BookOrderService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.demo.BookCatalogService.BookCatalogService;
import com.book.demo.BookInventoryService.BookInvetoryService;

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
