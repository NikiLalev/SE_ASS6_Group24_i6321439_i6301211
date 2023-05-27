package com.book.demo.BookInventoryMicroservice;

public interface BookInventoryService {
    public int getQuantityById(int id);
    public boolean setQuantityById(int id, int quantity);
    public boolean updateQuantityById(int id, int quantity);

}
