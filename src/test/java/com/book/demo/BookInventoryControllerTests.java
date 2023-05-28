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
public class BookInventoryControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetBookQuantityById() throws Exception {
        int bookId = 1; //the id of the book whose quantity we want to get
        String quantity = "20";
        mockMvc.perform(MockMvcRequestBuilders.post("/inventory/book/" + bookId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(quantity))
                .andExpect(MockMvcResultMatchers.status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/inventory/book/" + bookId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(quantity));
    }

    @Test
    public void testSetBookQuantityById() throws Exception {
        int bookId = 5; //the id of the book whose quantity we want to set
        String quantity = "20";
        mockMvc.perform(MockMvcRequestBuilders.post("/inventory/book/" + bookId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(quantity))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("true"));
    }

    @Test
    public void testUpdateBookQuantityById() throws Exception {
        int bookId = 2; //the id of the book whose quantity we want to update
        String quantity = "300";
        //need to create a book that has a quantity such that we can update it
        mockMvc.perform(MockMvcRequestBuilders.post("/inventory/book/" + bookId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(quantity))
                .andExpect(MockMvcResultMatchers.status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.put("/inventory/book/" + bookId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(quantity))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("true"));
    }
}
