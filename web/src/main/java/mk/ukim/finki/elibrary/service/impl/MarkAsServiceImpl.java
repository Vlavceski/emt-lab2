package mk.ukim.finki.elibrary.service.impl;

import mk.ukim.finki.elibrary.service.BookService;
import mk.ukim.finki.elibrary.service.MarkAsService;
import mk.ukim.finki.elibrary.model.Book;
import mk.ukim.finki.elibrary.model.MarkAs;
import mk.ukim.finki.elibrary.model.User;
import mk.ukim.finki.elibrary.repository.MarkAsRepository;
import mk.ukim.finki.elibrary.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarkAsServiceImpl implements MarkAsService {

    private final MarkAsRepository markAsRepository;
    private final UserRepository userRepository;
    private final BookService bookService;

    public MarkAsServiceImpl(MarkAsRepository markAsRepository, UserRepository userRepository, BookService bookService) {
        this.markAsRepository = markAsRepository;
        this.userRepository = userRepository;
        this.bookService = bookService;
    }

    @Override
    public List<Book> listAllBooksInMarkAs(Long markId) {
        if(this.markAsRepository.findById(markId).isPresent())
            throw new RuntimeException();
        return this.markAsRepository.findById(markId).get().getBooks();
    }

    @Override
    public MarkAs getActiveMarkAs(String username) {
        User user = this.userRepository.findByUsername(username)
                .orElseThrow(RuntimeException::new);

        return this.markAsRepository
                .findByUser(user)
                .orElseGet(() -> {
                    MarkAs mark = new MarkAs(user);
                    return this.markAsRepository.save(mark);
                });
    }

    @Override
    public MarkAs addBookToMarkAs(String username, Long bookId) {
        MarkAs markAs = this.getActiveMarkAs(username);
        Book book = this.bookService.findById(bookId)
                .orElseThrow(RuntimeException::new);
        if(markAs.getBooks()
                .stream().filter(i -> i.getId().equals(bookId))
                .collect(Collectors.toList()).size() > 0)
            throw new RuntimeException();
        markAs.getBooks().add(book);
       return this.markAsRepository.save(markAs);
    }

}
