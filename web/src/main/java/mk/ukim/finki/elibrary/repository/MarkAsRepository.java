package mk.ukim.finki.elibrary.repository;

import mk.ukim.finki.elibrary.model.MarkAs;
import mk.ukim.finki.elibrary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MarkAsRepository extends JpaRepository<MarkAs, Long> {
    Optional<MarkAs> findByUser(User user);
}
