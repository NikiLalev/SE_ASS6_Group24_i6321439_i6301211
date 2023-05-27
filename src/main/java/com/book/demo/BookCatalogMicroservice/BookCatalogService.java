package com.book.demo.BookCatalogMicroservice;

public interface BookCatalogService {
    public void addBook(Book book);
    public Book getByID(int ID);
    public boolean deleteBook(int ID);
    public boolean updateBook(Book book, int ID);
}
