package com.example.controle_archjee;

import com.example.controle_archjee.dao.entities.Book;
import com.example.controle_archjee.dao.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Date;

@SpringBootApplication
public class ControleArchJeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControleArchJeeApplication.class, args);
    }

    @Component
    public class DataInitializer implements CommandLineRunner {

        private final BookRepository bookRepository;

        public DataInitializer(BookRepository bookRepository) {
            this.bookRepository = bookRepository;
        }

        @Override
        public void run(String... args) {
            // Check if the database is empty before populating
            if (bookRepository.count() == 0) {
                // Create and save 4 books
                for (int i = 1; i <= 4; i++) {
                    Book book = new Book();
                    book.setTitle("Book Title " + i);
                    book.setPublisher("Publisher " + i);
                    book.setDate_Publication(new Date());
                    book.setPrice(25 * i); // Adjust the price as needed

                    bookRepository.save(book);
                }

                System.out.println("Database populated with 4 books.");
            }
        }
    }
}
