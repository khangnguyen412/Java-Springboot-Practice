package com.example.JavaSpingBootPractice.controller.lecture1;

public class Lecture1Book {
    private long id;
    private String name;
    private String author;
    private int price;

    public Lecture1Book(long id, String name, String author, int price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    // Thêm getters và setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Thêm các getters/setters khác...
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}