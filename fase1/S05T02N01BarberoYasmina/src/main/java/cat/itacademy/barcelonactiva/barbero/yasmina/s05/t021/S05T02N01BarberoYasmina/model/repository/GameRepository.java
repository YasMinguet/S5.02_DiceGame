package cat.itacademy.barcelonactiva.barbero.yasmina.s05.t021.S05T02N01BarberoYasmina.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import cat.itacademy.barcelonactiva.barbero.yasmina.s05.t021.S05T02N01BarberoYasmina.model.domain.Game;



public interface GameRepository extends JpaRepository<Game,Long> {
	
	
	
}
