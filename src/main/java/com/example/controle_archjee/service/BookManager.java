package com.example.controle_archjee.service;

import com.example.controle_archjee.service.dtos.BookDTO;

import java.util.List;

public interface BookManager {

    List<Object> getAllBooks();


    List<Object> getBooksByTitle(String title);


    List<Object> getBooksByPublisherAndPrice(String publisher, float price);


    BookDTO saveBook(BookDTO bookDTO);


    BookDTO deleteBookById(Long id);
}