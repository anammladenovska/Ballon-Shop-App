package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.model.Balloon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BalloonRepository extends JpaRepository<Balloon, Long> {
    Optional<Balloon> findByName(String name);
    void deleteByName(String name);
}
