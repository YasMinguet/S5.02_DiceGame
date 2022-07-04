package at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.domain.Game;
import at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.domain.Player;

@Service
public interface GameService {
	
	public Game saveGame(Game game);
	public List<Game> findAll();
	public Game playGame(Long idPlayer);
	public boolean deleteGames(Long playerId);
	public Player updatePercent(Optional<Player> op);
	public List<Game> findGamesByPlayer(Long playerId);

}
