package com.book.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringJUnitConfig
@SpringBootTest
@AutoConfigureMockMvc
public class BookCatalogControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetBookById() throws Exception {
        int bookId = 1;
        mockMvc.perform(MockMvcRequestBuilders.get("/catalog/book/" + bookId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":1,\"title\":\"To Kill a Mockingbird\",\"author\":\"Harper Lee\",\"publicationYear\":1960}"));
    }

    @Test
    public void testPostBook() throws Exception {
        String requestBody = "{\"title\":\"Game of Thrones\",\"author\":\"George Martin\",\"publicationYear\":1997, \"quantity\":\"30\"}";
        
        mockMvc.perform(MockMvcRequestBuilders.post("/catalog/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":7,\"title\":\"Game of Thrones\",\"author\":\"George Martin\",\"publicationYear\":1997}"));
    }

    @Test 
    public void testUpdateBook() throws Exception {
        String requestBody = "{\"id\":\"2\",\"title\":\"The Gambler\",\"author\":\"Dostoevsky\",\"publicationYear\":\"1860\"}";
        int bookId = 2; //we update the book with id = 2
        mockMvc.perform(MockMvcRequestBuilders.put("/catalog/book/" + bookId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":2,\"title\":\"The Gambler\",\"author\":\"Dostoevsky\",\"publicationYear\":1860}"));
    }

    @Test
    public void testDeleteBook() throws Exception {
        int bookId = 3; //we delete the book with id = 3
        mockMvc.perform(MockMvcRequestBuilders.delete("/catalog/book/" + bookId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("true"));
    }
}