package com.book.demo.Services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import com.book.demo.Model.Book;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class BookCatalogService {

    private List<Book> bookList;
    public BookCatalogService() {
        // Book 1
        Book book1 = new Book(0, "To Kill a Mockingbird", "Harper Lee", 1960, 8);

        // Book 2
        Book book2 = new Book(1, "1984", "George Orwell", 1949, 5);

        // Book 3
        Book book3 = new Book(2, "Pride and Prejudice", "Jane Austen", 1813, 12);

        // Book 4
        Book book4 = new Book(3, "The Catcher in the Rye", "J.D. Salinger", 1951, 3);

        // Book 5
        Book book5 = new Book(4, "The Hobbit", "J.R.R. Tolkien", 1937, 15);

        // Book 6
        Book book6 = new Book(5, "The Great Gatsby", "F. Scott Fitzgerald", 1925, 10);
        
        Book[] books = new Book[] {book1, book2, book3, book4, book5, book6};
        bookList = Arrays.asList(books);
    }
    
    /**
     * Pre: an integer is given that corresponds to a book in the database
     * Post: the book that corresponds to the given id is returned
     * @param ID - integer representing the id of the book we are looking for
     * @return - the book that correspond to the given id
     */
    public Book getByID(int ID) {
        Book foundBook = getBookList().stream().filter(book -> book.getId() == ID).findAny().orElse(null);
        return foundBook;
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

}
