package mk.ukim.finki.elibrary.service.impl;

import mk.ukim.finki.elibrary.service.CountryService;
import mk.ukim.finki.elibrary.model.Country;
import mk.ukim.finki.elibrary.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> save(String name, String continent) {
        return Optional.of(this.countryRepository.save(new Country(name, continent)));
    }

    @Override
    public void deleteById(Long id) {
        this.countryRepository.deleteById(id);
    }
}
