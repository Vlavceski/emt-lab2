package mk.ukim.finki.elibrary.service;

import mk.ukim.finki.elibrary.model.Book;
import mk.ukim.finki.elibrary.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> findByName(String name);

    Optional<Book> save(String name, Long author, Integer availableCopies);

    Optional<Book> save(BookDto productDto);

    Optional<Book> edit(Long id, String name, Long author, Integer availableCopies);

    Optional<Book> edit(Long id, BookDto productDto);

    void deleteById(Long id);
}
