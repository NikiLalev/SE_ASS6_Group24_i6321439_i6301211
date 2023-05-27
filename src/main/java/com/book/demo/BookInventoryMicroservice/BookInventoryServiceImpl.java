package com.book.demo.BookInventoryMicroservice;

import java.util.HashMap;
import org.springframework.stereotype.Service;

@Service
public class BookInventoryServiceImpl implements BookInventoryService{

    private HashMap<Integer, Integer> idToQuantityMap;

    public BookInventoryServiceImpl() {
        idToQuantityMap = new HashMap<Integer, Integer>();
    }
    
    /**
     * Pre: id is a key that exists the Id-Quantity data collection
     * Method for getting the quantity of a book given it's id
     * @param id - the id of the book, whose quantity we would like to know
     * @return - returns the quantity of the book 
     */
    @Override
    public int getQuantityById(int id) {
        //TO DO: handle invalid id case
        return idToQuantityMap.get(id);
    }

    /**
     * Pre: quantity is a non-negative number
     * When a book is created we set it's initial quantity
     * @param id
     * @param quantity
     * @return - returns true if the book associated with the provided id does not have a set quantity and false otherwise
     */
    @Override
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
    @Override
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
