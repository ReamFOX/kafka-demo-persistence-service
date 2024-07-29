package ua.farion.kafkademopersistenceservice.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.farion.kafkademopersistenceservice.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, UUID> {
}
