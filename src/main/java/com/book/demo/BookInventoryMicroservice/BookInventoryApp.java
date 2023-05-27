package com.book.demo.BookInventoryMicroservice;

import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookInventoryApp {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BookInventoryApp.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "3002"));
        app.run(args);
    }
}

