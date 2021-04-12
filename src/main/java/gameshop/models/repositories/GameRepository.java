package gameshop.models.repositories;

import gameshop.models.entities.Games;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Games, Long> {
}
