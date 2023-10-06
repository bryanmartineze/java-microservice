package com.example.CRUDApplication.controller;

import com.example.CRUDApplication.model.Book;
import com.example.CRUDApplication.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;



import java.util.*;


@RestController
@RequestMapping("/api")
public class BookController {
    
 
    @Autowired
    BookRepo bookRepo;
    
    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks() {
        try {
            List<Book> bookList = new ArrayList<>();
            bookRepo.findAll().forEach(bookList::add);
            
            if (bookList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            
            return new ResponseEntity<>(bookList, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    
    @GetMapping("/getBookById/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> bookData = bookRepo.findById(id);
        
        if (bookData.isPresent()) {
            return new ResponseEntity<>(bookData.get(), HttpStatus.OK);
        } else {
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }   
    
    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
       try { 
        Book bookObj = bookRepo.save(book);
        return new ResponseEntity<>(bookObj, HttpStatus.OK);
    } catch (Exception e) {
         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/updateBookById/{Id}")
    public ResponseEntity<Book> updateBookById(@PathVariable Long id, @RequestBody Book newBookData) {
         Optional<Book> oldBookData = bookRepo.findById(id);
         
         if (oldBookData.isPresent()) {
             Book updatedBookData = oldBookData.get();
             updatedBookData.setTitle(newBookData.getTitle());
             updatedBookData.setAuthor(newBookData.getAuthor());
             
             Book bookObj = bookRepo.save(updatedBookData);
             return new ResponseEntity<>(bookObj, HttpStatus.OK);
         }
         
         
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/deleteBookById/{id}")
    public ResponseEntity<HttpStatus> deleteBookById(@PathVariable Long id){
             bookRepo.deleteById(id);
             return new ResponseEntity<>(HttpStatus.OK);
        
    }
    
    
}
