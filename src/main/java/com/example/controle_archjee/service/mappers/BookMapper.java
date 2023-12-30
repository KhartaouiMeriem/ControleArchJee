package com.example.controle_archjee.service.mappers;

import com.example.controle_archjee.dao.entities.Book;
import com.example.controle_archjee.service.dtos.BookDTO;

public class BookMapper {

    public static BookDTO toDto(Book entity) {
        if (entity == null) {
            return null;
        }

        return new BookDTO(
                entity.getTitle(),
                entity.getPublisher(),
                entity.getDate_Publication(),
                entity.getPrice()
        );
    }

    public static Book toEntity(BookDTO dto) {
        if (dto == null) {
            return null;
        }

        Book entity = new Book();
        entity.setTitle(dto.getTitle());
        entity.setPublisher(dto.getPublisher());
        entity.setDate_Publication(dto.getDate_publication());
        entity.setPrice(dto.getPrice());

        return entity;
    }

    public BookDTO mapToDTO(Book book) {
        return toDto(book);
    }

    public Book mapToEntity(BookDTO bookDTO) {
        return toEntity(bookDTO);
    }
}
