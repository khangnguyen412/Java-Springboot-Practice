package com.example.JavaSpingBootPractice.repository;

import java.util.*;

import com.example.JavaSpingBootPractice.controller.lecture1.Lecture1Book;

public interface Lecture1BookInterface {

    Lecture1Book add_book(Lecture1Book book);

    Lecture1Book delete_book(Lecture1Book book);

    Lecture1Book update_book(long id, Lecture1Book book);

    List<Lecture1Book> get_all_book();

    Lecture1Book get_book_by_id(long id);

}
