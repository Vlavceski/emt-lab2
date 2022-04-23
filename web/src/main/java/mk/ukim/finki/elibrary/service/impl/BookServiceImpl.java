package mk.ukim.finki.elibrary.service.impl;

import mk.ukim.finki.elibrary.service.BookService;
import mk.ukim.finki.elibrary.model.Author;
import mk.ukim.finki.elibrary.model.Book;
import mk.ukim.finki.elibrary.model.dto.BookDto;
import mk.ukim.finki.elibrary.repository.AuthorRepository;
import mk.ukim.finki.elibrary.repository.BookRepository;
import org.springframework.stereotype.Service;

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
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> findByName(String name) {
        return this.bookRepository.findByName(name);
    }

    @Override
    public Optional<Book> save(String name, Long authorId, Integer availableCopies) {


                Author author = this.authorRepository.findById(authorId)
                .orElseThrow(RuntimeException::new);

        this.bookRepository.deleteByName(name);
        return Optional.of(this.bookRepository.save(new Book(name, author,availableCopies)));

    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(RuntimeException::new);
        this.bookRepository.deleteByName(bookDto.getName());
        return Optional.of(this.bookRepository.save(new Book(bookDto.getName(), author, bookDto.getAvailableCopies())));
    }

    @Override
    public Optional<Book> edit(Long id, String name, Long authorId, Integer availableCopies) {
        Book book = this.bookRepository.findById(id).orElseThrow(RuntimeException::new);

        book.setName(name);
        book.setAvailableCopies(availableCopies);
        Author author = this.authorRepository.findById(authorId)
                .orElseThrow(RuntimeException::new);
        book.setAuthor(author);
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id).orElseThrow(RuntimeException::new);
        book.setName(bookDto.getName());
        book.setAvailableCopies(bookDto.getAvailableCopies());

        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(RuntimeException::new);
        book.setAuthor(author);

        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }
}

