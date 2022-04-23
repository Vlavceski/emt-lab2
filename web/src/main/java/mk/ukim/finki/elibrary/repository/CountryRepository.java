package mk.ukim.finki.elibrary.repository;

import mk.ukim.finki.elibrary.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
