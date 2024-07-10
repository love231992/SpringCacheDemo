package com.example.springcache.controller;

import com.example.springcache.dto.Book;
import com.example.springcache.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping("/getBook")
    public Optional<Book> getBooks(@RequestParam Integer id){
       return bookService.getBooks(id);
    }
    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @PostMapping("/updateBook")
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @DeleteMapping("/delBook")
    public ResponseEntity<String> delBook(@RequestParam Integer id){
        bookService.delBook(id);
        return ResponseEntity.status(200).body("Entry has been deleted");
    }

}
