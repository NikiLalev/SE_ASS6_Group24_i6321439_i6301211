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
public class BookOrderControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAddOrderByBookId() throws Exception {
        //we create a book - the book has id = 6 and quantity = 30 and we want to order 10 of the books with id = 6
        String requestBody2 = "{\"bookId\": \"6\",\"quantity\": \"10\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/order/book/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody2))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("true"));
    }
}
