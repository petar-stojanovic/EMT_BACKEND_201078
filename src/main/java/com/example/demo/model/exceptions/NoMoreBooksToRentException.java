package com.example.demo.model.exceptions;

public class NoMoreBooksToRentException extends RuntimeException {
    public NoMoreBooksToRentException(String name) {
        super(String.format("No more books to rent for book \"%s\"", name));
    }
}
