package at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.domain.Player;

@Repository
public interface PlayerRepository extends MongoRepository<Player, Long> {

}
