package com.codegym.model.entity;

import javax.persistence.*;

@Entity
public class RentCode {
    @Id
    private long id;

    @ManyToOne(targetEntity = Book.class)
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private Book book;

    public RentCode() {
    }

    public RentCode(long id, Book book) {
        this.id = id;
        this.book = book;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
