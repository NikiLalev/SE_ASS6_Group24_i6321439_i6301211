package com.book.demo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.book.demo.BookCatalogMicroservice.BookCatalogController;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// @SpringBootTest
// @WebMvcTest(BookCatalogController.class)
// class BookCatalogControllerTest {

// 	@Autowired
//   	private MockMvc mvc;
// 	@Test
// 	public void createEmployeeAPI() throws Exception 
// 	{
// 	mvc.perform( MockMvcRequestBuilders
// 			.post("/catalog/book/10")
// 			.content("{\"id\":1,\"title\":\"1984\",\"author\":\"George Orwell\",\"year\":1949}")
// 			.contentType(MediaType.APPLICATION_JSON)
// 			.accept(MediaType.APPLICATION_JSON))

// 			//validate response
// 			.andExpect(status().isCreated())
// 			.andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").exists())
			
// 			// Validate the returned fields
// 			.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(2))
// 			.andExpect(MockMvcResultMatchers.jsonPath("$.title").value("1984"))
// 			.andExpect(MockMvcResultMatchers.jsonPath("$.author").value("George Orwell"))
// 			.andExpect(MockMvcResultMatchers.jsonPath("$.publicationYear").value(1949));
// 	}

// }
