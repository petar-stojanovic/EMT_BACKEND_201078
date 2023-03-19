package com.example.demo.service;

import com.example.demo.model.Author;
import com.example.demo.model.Country;

import java.util.List;

public interface AuthorService {

    List<Author> findAll();

    List<Author> saveAll(List<Author> authors);
}
