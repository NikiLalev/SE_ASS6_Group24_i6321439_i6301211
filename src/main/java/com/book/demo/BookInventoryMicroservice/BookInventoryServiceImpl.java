package com.book.demo.BookInventoryMicroservice;

import java.util.HashMap;
import org.springframework.stereotype.Service;

@Service
public class BookInventoryServiceImpl {

    private HashMap<Integer, Integer> idToQuantityMap;

    public BookInventoryServiceImpl() {
        idToQuantityMap = new HashMap<Integer, Integer>();
    }
    
    public int getQuantityById(int id) {
        return idToQuantityMap.get(id);
    }

    /**
     * Pre: quantity is a non-negative number
     * When a book is created we set it's initial quantity
     * @param id
     * @param quantity
     * @return - returns true if the book associated with the provided id does not have a set quantity and false otherwise
     */
    public boolean setQuantityById(int id, int quantity) {
        if(idToQuantityMap.get(id) == null) {
            idToQuantityMap.put(id, quantity);
            return true;
        } else {
            return false;
            //else throw an exception
        }
    }

    /**
     * Pre: quantity is a non-negative number
     * We update the quantity of an existing book
     * @param id
     * @param quantity
     * @return - returns true if the update was successful and false otherwise
     */
    public boolean updateQuantityById(int id, int quantity) {
        if(idToQuantityMap.get(id) != null) { //check that book qunatity is present
            idToQuantityMap.put(id, idToQuantityMap.get(id) + quantity);
            return true;
        } else {
            return false;
            //else throw an exception
        } 
    }
}
