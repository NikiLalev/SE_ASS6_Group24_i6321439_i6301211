package com.book.demo.Model;

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
