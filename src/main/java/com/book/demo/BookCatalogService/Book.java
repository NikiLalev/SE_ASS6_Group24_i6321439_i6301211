package com.book.demo.BookCatalogService;


import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Book {

    
    private @Id @GeneratedValue(strategy = GenerationType.AUTO) int id;
    private String title;
    private String author;
    private int publicationYear;
}
