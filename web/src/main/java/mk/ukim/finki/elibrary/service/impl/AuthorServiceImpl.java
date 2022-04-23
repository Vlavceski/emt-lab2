package mk.ukim.finki.elibrary.service.impl;

import mk.ukim.finki.elibrary.service.AuthorService;
import mk.ukim.finki.elibrary.model.Author;
import mk.ukim.finki.elibrary.model.Country;
import mk.ukim.finki.elibrary.repository.AuthorRepository;
import mk.ukim.finki.elibrary.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> save(String name, String surname, Long countryId) {
        Country country = this.countryRepository.findById(countryId)
                .orElseThrow(RuntimeException::new);
        return Optional.of(this.authorRepository.save(new Author(name, surname, country)));
    }

    @Override
    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);
    }
}

//    @Override
//    public Author create(String name, String description) {
//        if (name==null || name.isEmpty()) {
//            throw new IllegalArgumentException();
//        }
//        Author c = new Author(name,description);
//        categoryRepository.save(c);
//        return c;
//    }
//
//    @Override
//    public Author update(String name, String description) {
//        if (name==null || name.isEmpty()) {
//            throw new IllegalArgumentException();
//        }
//        Author c= new Author(name,description);
//        categoryRepository.save(c);
//        return c;
//    }
//
//    @Override
//    public void delete(String name) {
//        if (name==null || name.isEmpty()) {
//            throw new IllegalArgumentException();
//        }
//        categoryRepository.deleteByName(name);
//    }
//
//    @Override
//    public List<Author> listCategories() {
//        return categoryRepository.findAll();
//    }
//
//    @Override
//    public List<Author> searchCategories(String searchText) {
//        return categoryRepository.findAllByNameLike(searchText);
//    }

