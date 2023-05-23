package com.book.demo;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Book {

    private @Id @GeneratedValue int id;
    private String title;
    private String author;
    private int publicationYear;
    private int quantity;

    public Book(int id, String title, String author, int publicationYear, int quantity){
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.quantity = quantity;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getPublicationYear() {
        return this.publicationYear;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int newQuantity){
        this.quantity = newQuantity;
    }
}
