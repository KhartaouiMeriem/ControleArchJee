package com.example.controle_archjee.service.mappers;

import com.example.controle_archjee.dao.entities.Book;
import com.example.controle_archjee.dao.repositories.BookRepository;
import com.example.controle_archjee.service.BookManager;
import com.example.controle_archjee.service.dtos.BookDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookManagerAction implements BookManager {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookManagerAction(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<Object> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(bookMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<Object> getBooksByTitle(String title) {
        List<Book> books = bookRepository.findBytitle(title);
        return books.stream().map(bookMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<Object> getBooksByPublisherAndPrice(String publisher, float price) {
        List<Book> books = bookRepository.findByPublisherAndPrice(publisher, (int) price);
        return books.stream().map(bookMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public BookDTO saveBook(BookDTO bookDTO) {

        if (bookRepository.existsByTitleAndPublisher(bookDTO.getTitle(), bookDTO.getPublisher())) {
            throw new RuntimeException("A book with the same title and publisher already exists.");
        }


        Book bookToSave = bookMapper.mapToEntity(bookDTO);


        Book savedBook = bookRepository.save(bookToSave);


        return bookMapper.mapToDTO(savedBook);
    }



    @Override
    public BookDTO deleteBookById(Long id) {
        Optional<Book> bookToDelete = bookRepository.findById(id);

        if (bookToDelete.isPresent()) {

            bookRepository.delete(bookToDelete.get());
            return bookMapper.mapToDTO(bookToDelete.get());
        } else {
            throw new RuntimeException("Livre non trouvé avec l'ID : " + id);
        }
    }
}