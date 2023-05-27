package com.book.demo.BookOrderMicroservice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.demo.BookCatalogMicroservice.BookCatalogServiceImpl;
import com.book.demo.BookInventoryMicroservice.BookInventoryServiceImpl;

@Service
public class BookOrderServiceImpl implements BookOrderService {
    private List<Order> orderList;

    @Autowired
    BookCatalogServiceImpl bookCatalogService;
    BookInventoryServiceImpl bookInvetoryService;

    @Override
    public void sendOrder(Order order) {
        //need to add the web requests instead of using the service classes
        if(bookCatalogService.getById(order.getBookId()) != null &&
            bookInvetoryService.getQuantityById(order.getBookId()) <= order.getQuantity()) {
                orderList.add(order);
           }    
    }
}
