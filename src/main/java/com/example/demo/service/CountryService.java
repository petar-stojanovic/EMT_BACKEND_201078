package com.example.demo.service;

import com.example.demo.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> findAll();

    List<Country> saveAll(List<Country> countries);
}
