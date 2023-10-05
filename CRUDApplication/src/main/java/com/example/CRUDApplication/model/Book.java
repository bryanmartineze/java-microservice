package com.example.CRUDApplication.model;

import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name="Books")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Book {
    
    private Long id;
    private String title;
    private String author;
    
    
    
}