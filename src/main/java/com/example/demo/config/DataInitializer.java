//package com.example.demo.config;
//
//
//import com.example.demo.model.Author;
//import com.example.demo.model.Book;
//import com.example.demo.model.Country;
//import com.example.demo.service.AuthorService;
//import com.example.demo.service.BookService;
//import com.example.demo.service.CountryService;
//import jakarta.annotation.PostConstruct;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//@Component
//public class DataInitializer {
//
//    private final CountryService countryService;
//    private final AuthorService authorService;
//    private final BookService bookService;
//
//    public DataInitializer(CountryService countryService, AuthorService authorService, BookService bookService) {
//        this.countryService = countryService;
//        this.authorService = authorService;
//        this.bookService = bookService;
//    }
//
//

//    @PostConstruct
//    public void initData() {
//        List<Country> countries = new ArrayList<>();
//        for (int i = 0; i < 6; i++) {
//            Country country = new Country();
//            country.setName(getRandomName());
//            country.setContinent(getRandomContinent());
//            countries.add(country);
//        }
//        countryRepository.saveAll(countries);
//
//        List<Author> authors = new ArrayList<>();
//        for (int i = 0; i < 6; i++) {
//            Author author = new Author();
//            author.setName(getRandomName());
//            author.setSurname(getRandomSurname());
//            author.setCountry(countries.get(i));
//            authors.add(author);
//        }
//        authorRepository.saveAll(authors);
//
//        List<Book> books = new ArrayList<>();
//        Random random = new Random();
//        for (int i = 0; i < 6; i++) {
//            Book book = new Book();
//            book.setName(getRandomName());
//            book.setCategory(getRandomCategory());
//            book.setAuthor(authors.get(i));
//            book.setAvailableCopies(random.nextInt(10) + 1);
//            books.add(book);
//        }
//        bookRepository.saveAll(books);
//    }
//
//    private String getRandomName() {
//        List<String> names = Arrays.asList("The Great Gatsby", "Pride and Prejudice", "To Kill a Mockingbird",
//                "1984", "The Catcher in the Rye", "Brave New World", "One Hundred Years of Solitude",
//                "Invisible Man", "Beloved", "The Color Purple");
//        Random random = new Random();
//        return names.get(random.nextInt(names.size()));
//    }
//
//    private String getRandomSurname() {
//        List<String> surnames = Arrays.asList("Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis",
//                "Garcia", "Rodriguez", "Martinez");
//        Random random = new Random();
//        return surnames.get(random.nextInt(surnames.size()));
//    }
//
//    private String getRandomContinent() {
//        List<String> continents = Arrays.asList("Asia", "Africa", "North America", "South America", "Antarctica",
//                "Europe", "Australia");
//        Random random = new Random();
//        return continents.get(random.nextInt(continents.size()));
//    }
//
//    private BookCategory getRandomCategory() {
//        Random random = new Random();
//        return BookCategory.values()[random.nextInt(BookCategory.values().length)];
//    }
//}
