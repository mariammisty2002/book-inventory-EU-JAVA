package com.example.bookinventory.controller;

import com.example.bookinventory.model.Book;
import com.example.bookinventory.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Book add(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping
    public Book update(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping
    public List<Book> getAll() {
        return bookService.getAllBooks();
    }

    @GetMapping("/author/{author}")
    public List<Book> byAuthor(@PathVariable String author) {
        return bookService.filterByAuthor(author);
    }

    @GetMapping("/genre/{genre}")
    public List<Book> byGenre(@PathVariable String genre) {
        return bookService.filterByGenre(genre);
    }

    @GetMapping("/low-stock")
    public List<Book> lowStock(@RequestParam(defaultValue = "5") int threshold) {
        return bookService.lowStockBooks(threshold);
    }

    @GetMapping("/total-stock")
    public int totalStock() {
        return bookService.getTotalStock();
    }
}