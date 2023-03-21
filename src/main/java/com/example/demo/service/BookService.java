package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.model.Country;
import com.example.demo.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    List<Book> saveAll(List<Book> countries);

    Optional<Book> findById(Long id);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long id, BookDto bookDto);

    void rentBook(Long id);

    void deleteById(Long id);

}
