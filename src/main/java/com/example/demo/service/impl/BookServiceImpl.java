package com.example.demo.service.impl;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.dto.BookDto;
import com.example.demo.model.enumerations.Category;
import com.example.demo.model.exceptions.AuthorNotFoundException;
import com.example.demo.model.exceptions.BookNotFoundException;
import com.example.demo.model.exceptions.CategoryNotFoundException;
import com.example.demo.model.exceptions.NoMoreBooksToRentException;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public List<Book> saveAll(List<Book> books) {
        return this.bookRepository.saveAll(books);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Book> save(BookDto bookDto) {
        Category category = bookDto.getCategory();

        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));

        this.bookRepository.deleteByName(bookDto.getName());
        Book book = new Book(bookDto.getName(), category, author, bookDto.getAvailableCopies());
        this.bookRepository.save(book);

        return Optional.of(book);
    }

    @Override
    @Transactional
    public Optional<Book> edit(Long id, BookDto bookDto) {

        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());

        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));

        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());


        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void rentBook(Long id) {
        Book book = this.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        if (book.getAvailableCopies() == 0) {
            throw new NoMoreBooksToRentException(book.getName());
        }

        book.setAvailableCopies(book.getAvailableCopies() - 1);
        this.bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }


}
