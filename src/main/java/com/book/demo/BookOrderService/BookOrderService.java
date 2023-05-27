package com.book.demo.BookOrderService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.book.demo.BookCatalogService.BookCatalogServiceImpl;
import com.book.demo.BookInventoryService.BookInventoryService;

@Service
public class BookOrderService {
    private List<Order> orderList;

    @Autowired
    BookCatalogServiceImpl bookCatalogService;
    BookInventoryService bookInvetoryService;

    public void sendOrder(Order order) {
        if(bookCatalogService.getByID(order.getBookId()) != null &&
            bookInvetoryService.getQuantityByID(order.getBookId()) <= order.getQuantity()) {
                orderList.add(order);
           }    
    }
}
