package com.example.CRUDApplication.model;

import lombok.*;
import jakarta.persistence.*;


@Entity
@Table(name="Books")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String title;
    
    @Column
    private String author;
    
    
    
}