package cat.itacademy.barcelonactiva.barbero.yasmina.s05.t021.S05T02N01BarberoYasmina.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.barbero.yasmina.s05.t021.S05T02N01BarberoYasmina.model.domain.Player;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}
