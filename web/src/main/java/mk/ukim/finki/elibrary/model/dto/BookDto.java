package mk.ukim.finki.elibrary.model.dto;

import lombok.Data;
import mk.ukim.finki.elibrary.model.enumerations.Category;

@Data
public class BookDto {


    private String name;

    private Category category;

    private Long author;

    private Integer availableCopies;

    public BookDto() {
    }

    public BookDto(String name, Long author, Integer availableCopies) {
        this.name = name;
        this.category = Category.DRAMA;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
