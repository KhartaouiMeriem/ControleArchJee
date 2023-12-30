package com.example.controle_archjee.dao.repositories;


import com.example.controle_archjee.dao.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBytitle(String title);

    List<Book> findByPublisherAndPrice(String publisher, int price);

    boolean existsByTitleAndPublisher(String title, String publisher);
}

