package com.book.demo.BookOrderMicroservice;

import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookOrderApp {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BookOrderApp.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "3003"));
        app.run(args);
    }
}