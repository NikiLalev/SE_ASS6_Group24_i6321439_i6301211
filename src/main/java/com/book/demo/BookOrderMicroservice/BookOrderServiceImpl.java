package com.book.demo.BookOrderMicroservice;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BookOrderServiceImpl implements BookOrderService {
    private List<Order> orderList;

    public BookOrderServiceImpl() {
        orderList = new ArrayList<Order>();
    }
    @Override
    public void sendOrder(Order order) {
        orderList.add(order);
    }      
}
