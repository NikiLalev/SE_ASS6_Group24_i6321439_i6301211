package com.book.demo;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.reactive.function.client.WebClient;

import com.book.demo.BookCatalogMicroservice.Book;
import com.book.demo.BookCatalogMicroservice.BookCatalogController;
import com.book.demo.BookCatalogMicroservice.BookCatalogServiceImpl;
import com.book.demo.BookInventoryMicroservice.BookInventoryServiceImpl;

public class BookCatalogControllerTest {

    private MockMvc mockMvc;
    private Book book;

    @Mock
    private BookCatalogServiceImpl bookCatalogServiceImpl;

    @Mock
    private BookInventoryServiceImpl bookInventoryService;

    @Mock
    private WebClient.Builder webClientBuilder; 

    @InjectMocks
    private BookCatalogController bookCatalogController = new BookCatalogController(WebClient.builder());

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        // WebClient webClient = Mockito.mock(WebClient.class);
        // when(webClientBuilder.baseUrl(anyString())).thenReturn(webClientBuilder);
        // when(webClientBuilder.build()).thenReturn(webClient);
        mockMvc = MockMvcBuilders.standaloneSetup(bookCatalogController).build();
        book = new Book("1984", "George Orwell", 1949);
    }

    @Test
    public void testGetBookById() throws Exception {

        when(bookCatalogServiceImpl.getById(1)).thenReturn(book);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/catalog/book/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.author").value("George Orwell"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("1984"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.publicationYear").value(1949));
            }       

    @Test //TO-DO
    public void testCreateBook() throws Exception {
        // Arrange
        int bookId = 1;
        int quantity = 30;
    
        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/catalog/book")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"title\":\"1984\",\"author\":\"George Orwell\",\"publicationYear\":1949, \"quantity\": \"30\"}"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(bookId))
        .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("1984"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.publicationYear").value(1949))
        .andExpect(MockMvcResultMatchers.jsonPath("$.quantity").value(30));
    }

    @Test //TO-DO
    public void testUpdateBook() throws Exception {

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.put("/catalog/book/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"title\":\"1984\",\"author\":\"George Orwell\",\"publicationYear\":1949}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(book.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.author").value("George Orwell"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("1984"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.publicationYear").value(1949));

        verify(bookCatalogServiceImpl, times(1)).updateBook(book, 1);
    }

    @Test
    public void testDeleteBook() throws Exception {
        // Arrange
        int bookId = 1;

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.delete("/catalog/book/{id}", bookId))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(bookCatalogServiceImpl, times(1)).deleteBook(bookId);
    }
}