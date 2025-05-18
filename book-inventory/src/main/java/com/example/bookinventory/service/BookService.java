package com.example.bookinventory.service;

import com.example.bookinventory.model.Book;
import com.example.bookinventory.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepo;

    public Book addBook(Book book) { return bookRepo.save(book); }
    public List<Book> getAllBooks() { return bookRepo.findAll(); }
    public void deleteBook(Long id) { bookRepo.deleteById(id); }
    public Book updateBook(Book book) { return bookRepo.save(book); }

    public List<Book> filterByAuthor(String author) {
        return bookRepo.findByAuthor(author);
    }

    public List<Book> filterByGenre(String genre) {
        return bookRepo.findByGenre(genre);
    }

    public List<Book> lowStockBooks(int threshold) {
        return bookRepo.findByQuantityLessThan(threshold);
    }

    public int getTotalStock() {
        return bookRepo.findAll().stream().mapToInt(Book::getQuantity).sum();
    }
}