package com.book.demo.Model;


import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Book {

    
    private @Id @GeneratedValue(strategy = GenerationType.AUTO) int id;
    private String title;
    private String author;
    private int publicationYear;
    private int quantity;

    public void setQuantity(int newQuantity){
        this.quantity = newQuantity;
    }
}
