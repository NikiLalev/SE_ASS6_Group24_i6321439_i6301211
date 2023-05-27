package com.book.demo.BookCatalogMicroservice;

public interface BookCatalogService {
    public void addBook(Book book);
    public Book getById(int id);
    public boolean deleteBook(int id);
    public boolean updateBook(Book book, int id);
}
