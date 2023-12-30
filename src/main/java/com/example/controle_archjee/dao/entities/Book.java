package com.example.controle_archjee.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Book;
    private String title;
    private String publisher;
    private Date date_Publication;
    private int price;
    private String Resume;
}
