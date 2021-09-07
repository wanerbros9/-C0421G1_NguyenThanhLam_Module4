package com.codegym.model.service;

import com.codegym.model.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findById(int id);

    void save(Book book);
}
