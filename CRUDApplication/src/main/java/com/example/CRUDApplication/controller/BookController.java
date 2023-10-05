package com.example.CRUDApplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


import com.example.CRUDApplication.model.Book;
import com.example.CRUDApplication.repo.BookRepo;

@RestController
public class BookController {
    
 
    @Autowired
    private BookRepo bookRepo;
    
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        try {
            List<Book> bookList = new ArrayList<>();
            bookRepo.findAll().forEach(bookList::add);
            
            if (bookList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    
    @GetMapping
    public void getBookById() {
        
    }
    
    @PostMapping
    public void addBook() {
        
    }
    
    @PostMapping
    public void updateBookById() {
        
    }
    
    @DeleteMapping
    public void deleteBookById(){
        
    }
    
    
}
