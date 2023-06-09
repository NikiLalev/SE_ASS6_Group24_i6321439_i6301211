package com.book.demo.BookCatalogMicroservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private static int counter = 0;
    private int id;
    private String title;
    private String author;
    private int publicationYear;

    public Book(String title, String author, int publicationYear) {
        this.id = ++counter;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }
}
