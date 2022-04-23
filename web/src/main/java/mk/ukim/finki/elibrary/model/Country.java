package mk.ukim.finki.elibrary.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "countries_Data")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String continent;

    public Country() {
    }

    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }
}
