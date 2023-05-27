package com.book.demo.BookCatalogMicroservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class BookCatalogServiceImpl implements BookCatalogService{

    private List<Book> bookList;
    public BookCatalogServiceImpl() {
        // Book 1
        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);

        // Book 2
        Book book2 = new Book("1984", "George Orwell", 1949);

        // Book 3
        Book book3 = new Book("Pride and Prejudice", "Jane Austen", 1813);

        // Book 4
        Book book4 = new Book("The Catcher in the Rye", "J.D. Salinger", 1951);

        // Book 5
        Book book5 = new Book("The Hobbit", "J.R.R. Tolkien", 1937);

        // Book 6
        Book book6 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        
        Book[] books = new Book[] {book1, book2, book3, book4, book5, book6};
        bookList = new ArrayList<Book>(Arrays.asList(books));
    }
    
    /**
     * Pre: an integer is given that corresponds to a book in the database
     * Post: the book that corresponds to the given id is returned
     * @param ID - integer representing the id of the book we are looking for
     * @return - the book that correspond to the given id
     */
    @Override
    public Book getByID(int ID) {
        Book foundBook = getBookList().stream().filter(book -> book.getId() == ID).findAny().orElse(null);
        return foundBook;
    }

    /**
     * Adds a book to the collection of books
     * @param book - the book that we would like add
     */
    @Override
    public void addBook(Book book) {
        bookList.add(book);
    }

    /**
     * Pre: an integer is given that corresponds to a book in the database
     * @param ID - the id of the book that needs to be deleted
     * @return - return true if the book was successfully removed
     */
    @Override
    public boolean deleteBook(int ID) {
        Book bookToRemove = getByID(ID);
        return getBookList().remove(bookToRemove);
    }

    @Override
    public void updateBook(Book book, int ID) {
        
    }

}
