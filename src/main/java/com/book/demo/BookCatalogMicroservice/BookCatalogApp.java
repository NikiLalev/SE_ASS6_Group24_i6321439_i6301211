package com.book.demo.BookCatalogMicroservice;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookCatalogApp {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BookCatalogApp.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "3001"));
        app.run(args);
    }
}
