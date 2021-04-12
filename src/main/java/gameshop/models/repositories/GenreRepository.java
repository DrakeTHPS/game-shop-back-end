package gameshop.models.repositories;

import gameshop.models.entities.Genres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genres, Long> {
}
