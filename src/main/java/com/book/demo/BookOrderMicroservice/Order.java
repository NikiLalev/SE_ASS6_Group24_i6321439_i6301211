package com.book.demo.BookOrderMicroservice;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class Order {
    private static int counter = 0;
    private int orderId;
    private int bookId;
    private int quantity;
    private LocalDate date;

    public Order(int bookId, int quantity) {
        this.orderId = ++counter;
        this.bookId = bookId;
        this.quantity = quantity;
        this.date = LocalDate.now();
    }
}
