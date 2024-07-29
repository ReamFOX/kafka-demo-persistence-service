package ua.farion.kafkademopersistenceservice.service;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ua.farion.kafkademopersistenceservice.dto.PlayerDto;
import ua.farion.kafkademopersistenceservice.entity.Player;
import ua.farion.kafkademopersistenceservice.repository.PlayerRepository;

@Service
@RequiredArgsConstructor
public class PersistenceService {
    private final PlayerRepository playerRepository;

    @KafkaListener(topics = "signup-topic", groupId = "persistance-group")
    public void consume(String playerId, PlayerDto playerDto) {
        Player player = new Player();
        player.setId(UUID.fromString(playerId));
        player.setEmail(playerDto.email());
        player.setPassword(playerDto.password());
        playerRepository.save(player);
    }
}
