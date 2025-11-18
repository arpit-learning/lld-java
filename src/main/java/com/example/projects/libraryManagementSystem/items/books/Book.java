package com.example.projects.libraryManagementSystem.items.books;

import com.example.projects.libraryManagementSystem.items.Item;

public class Book extends Item {
    private String isbn;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int itemId, String isbn, String title, String author, boolean isAvailable) {
        super(itemId);
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    @Override
    public void getDetails() {
        System.out.println("Book title: " + this.title);
        System.out.println("Book author: " + this.author);
        System.out.println("Book isAvailable: " + this.isAvailable);
    }

    // getters setters
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean getIsAvailable() {
        return this.isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
