package com.book.demo.BookInventoryService;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.book.demo.BookCatalogService.BookCatalogServiceImpl;

@Service
public class BookInventoryService {

    private HashMap<Integer, Integer> idToQuantityMap;
    
    @Autowired
    BookCatalogServiceImpl bookCatalogService;

    public BookInventoryService() {
        idToQuantityMap = new HashMap<Integer, Integer>();
    }
    
    public int getQuantityByID(int ID) {
        return idToQuantityMap.get(ID);
    }

    /**
     * Pre: quantity is a non-negative number
     * We update the quantity of an existing book
     * @param ID
     * @param quantity
     */
    public void updateQuantityByID(int ID, int quantity) {
        if(idToQuantityMap.get(ID) != null) { //check that book qunatity is present
            idToQuantityMap.put(ID, idToQuantityMap.get(ID) + quantity);
        }
        //else throw an exception
    }

    /**
     * Pre: quantity is a non-negative number
     * When a book is created we set it's initial quantity
     * @param ID
     * @param quantity
     */
    public void setQuantityByID(int ID, int quantity) {
        if(idToQuantityMap.get(ID) == null) {
            idToQuantityMap.put(ID, quantity);
        }
        //else throw an exception
    }
}
