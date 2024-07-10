package com.example.springcache.service;

import com.example.springcache.dto.Book;
import com.example.springcache.repository.BookRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {

    BookRepo bookRepo;

    Logger logger = LoggerFactory.getLogger(BookService.class);

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Book addBook(Book book){
      return  bookRepo.save(book);
    }

    @Cacheable(cacheNames = "books", key = "#id")
    public Optional<Book> getBooks(Integer id){
        logger.info("Getting books from DB");
        return bookRepo.findById(id);
    }

    @CachePut(cacheNames = "books",key = "#book.bookId")
    public Book updateBook(Book book){
        logger.info("Updating book in DB");
        return bookRepo.save(book);
    }

    @CacheEvict(cacheNames = "books",key = "#id")
    public String delBook(Integer id){
        logger.info("Deleting book from DB");
        bookRepo.deleteById(id);
        return "Book has been deleted";
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }
}
