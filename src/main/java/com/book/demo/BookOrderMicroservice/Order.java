package com.book.demo.BookOrderMicroservice;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class Order {
    private int bookId;
    private int quantity;
    private LocalDate date;
}
