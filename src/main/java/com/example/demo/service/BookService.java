package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.model.Country;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    List<Book> saveAll(List<Book> countries);

}
