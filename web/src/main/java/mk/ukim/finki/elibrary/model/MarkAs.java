package mk.ukim.finki.elibrary.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class MarkAs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateCreated;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<Book> books;
    @ManyToMany
    private List<Author> authors;

    public MarkAs() {
    }

    public MarkAs(User user) {
        this.dateCreated = LocalDateTime.now();
        this.user = user;
        this.books = new ArrayList<>();
        this.authors = new ArrayList<>();
    }
}
