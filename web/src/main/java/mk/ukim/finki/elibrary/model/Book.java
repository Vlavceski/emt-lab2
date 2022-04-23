package mk.ukim.finki.elibrary.model;

import lombok.Data;
import mk.ukim.finki.elibrary.model.enumerations.Category;

import javax.persistence.*;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    private Author author;

    private Integer availableCopies;

    public Book() {
    }

    public Book(String name, Author author, Integer availableCopies) {
        this.name = name;
        this.category = Category.DRAMA;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
