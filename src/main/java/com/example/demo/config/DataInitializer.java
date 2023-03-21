package com.example.demo.config;


import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Country;
import com.example.demo.model.enumerations.Category;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;
import com.example.demo.service.CountryService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DataInitializer {

    private final CountryService countryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public DataInitializer(CountryService countryService, AuthorService authorService, BookService bookService) {
        this.countryService = countryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }


    @PostConstruct
    public void initData() {

        List<Country> countries = new ArrayList<>();
        countries.add(new Country("United States", "North America"));
        countries.add(new Country("Brazil", "South America"));
        countries.add(new Country("Germany", "Europe"));
        countries.add(new Country("Japan", "Asia"));
        countries.add(new Country("South Africa", "Africa"));
        countries.add(new Country("Australia", "Australia"));
        countryService.saveAll(countries);

        Random rand = new Random();

        List<Author> authors = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int randomCountryNumber = rand.nextInt(countries.size());
            Author author = new Author("Name " + (i + 1), "Surname " + (i + 1), countries.get(randomCountryNumber));
            authors.add(author);
        }
        authorService.saveAll(authors);


        List<Book> books = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int randomAuthorNumber = rand.nextInt(authors.size());
            Book book = new Book("Book " + (i + 1), Category.getRandom(), authors.get(randomAuthorNumber), rand.nextInt(10));

            books.add(book);
        }
        bookService.saveAll(books);
    }
}

