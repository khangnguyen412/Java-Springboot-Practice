package com.example.JavaSpingBootPractice.repository;

import java.util.*;
import org.springframework.stereotype.Repository;

import com.example.JavaSpingBootPractice.controller.lecture1.Lecture1Book;

@Repository
public class Lecture1BookRepository implements Lecture1BookInterface {
    private HashMap<Long, Lecture1Book> books = new HashMap<>();
    private long current_id = 1L;

    public Lecture1BookRepository() {
        // Khởi tạo một vài dữ liệu mẫu
        add_book(new Lecture1Book(0L, "Clean Code", "Robert Martin", 350000));
        add_book(new Lecture1Book(0L, "Design Patterns", "Gang of Four", 380000));
    }

    public List<Lecture1Book> get_all_book() {
        return new ArrayList<>(books.values());
    }

    public Lecture1Book get_book_by_id(long id) {
        return books.get(id);
    }

    public Lecture1Book add_book(Lecture1Book book) {
        book.setId(current_id++);
        books.put(book.getId(), book);
        return book;
    }

    public Lecture1Book update_book(long id, Lecture1Book book) {
        return books.put(id, book);
    }

    public Lecture1Book delete_book(Lecture1Book book) {
        return books.remove(book.getId());
    }
}
