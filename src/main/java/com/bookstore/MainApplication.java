package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            bookstoreService.persistNewAuthor();
            bookstoreService.fetchAuthor();
        };
    }
}
/*
 * How To Map Java enum To PostgreSQL enum Type

Description: This application maps a Java enum type to PostgreSQL enum type.

Key points:

define a custom Hibernate EnumType
register this custom EnumType via package-info.java
annotate the corresponding entity field @Type

 * 
 */
