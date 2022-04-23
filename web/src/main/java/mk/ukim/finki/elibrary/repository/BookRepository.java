package mk.ukim.finki.elibrary.repository;

import mk.ukim.finki.elibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByName(String name);
    void deleteByName(String name);
}
