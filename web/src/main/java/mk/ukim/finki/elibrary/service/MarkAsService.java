package mk.ukim.finki.elibrary.service;

import mk.ukim.finki.elibrary.model.Book;
import mk.ukim.finki.elibrary.model.MarkAs;

import java.util.List;

public interface MarkAsService {

    List<Book> listAllBooksInMarkAs(Long cartId);
    MarkAs getActiveMarkAs(String username);
    MarkAs addBookToMarkAs(String username, Long productId);
}
