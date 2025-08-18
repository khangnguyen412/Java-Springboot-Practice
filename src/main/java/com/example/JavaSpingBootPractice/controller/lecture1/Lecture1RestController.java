package com.example.JavaSpingBootPractice.controller.lecture1;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.example.JavaSpingBootPractice.repository.*;

@RestController
@RequestMapping("/lecture1/api")
public class Lecture1RestController {
    private final Lecture1BookRepository lecture1_book_repository;

    @Autowired
    public Lecture1RestController(Lecture1BookRepository lecture1_book_repository) {
        this.lecture1_book_repository = lecture1_book_repository;
    }

    @GetMapping("/get-all")
    public List<Lecture1Book> get_all_books() {
        List<Lecture1Book> books = lecture1_book_repository.get_all_book();
        return books;
    }

    @GetMapping("/get-book/{id}")
    public ResponseEntity<Lecture1Book> get_book_by_id(@PathVariable long id) {
        Lecture1Book book = lecture1_book_repository.get_book_by_id(id);
        if (!Objects.isNull(book)) {
            return ResponseEntity.status(HttpStatus.OK).body(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Test bằng postman
     * - Chọn POST
     * - Chọn Body
     * - Chọn raw
     * - Chọn JSON
     * - Nhập dữ liệu JSON
     */
    @PostMapping("/add-book")
    public ResponseEntity<List<Lecture1Book>> create_book(@RequestBody Lecture1Book book) {
        lecture1_book_repository.add_book(book);
        List<Lecture1Book> data = lecture1_book_repository.get_all_book();
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    } 

    /**
     * Test bằng postman
     * - Chọn PUT
     * - Chọn Body
     * - Chọn raw
     * - Chọn JSON
     * - Nhập dữ liệu JSON
     */
    @PutMapping("/update-book/{id}")
    public ResponseEntity<List<Lecture1Book>> update_book(@PathVariable long id, @RequestBody Lecture1Book book) {
        lecture1_book_repository.update_book(id, book);
        List<Lecture1Book> data = lecture1_book_repository.get_all_book();
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
}