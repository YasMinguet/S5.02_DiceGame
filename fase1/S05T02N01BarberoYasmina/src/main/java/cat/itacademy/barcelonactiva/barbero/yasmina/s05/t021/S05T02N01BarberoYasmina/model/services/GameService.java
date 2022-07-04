package cat.itacademy.barcelonactiva.barbero.yasmina.s05.t021.S05T02N01BarberoYasmina.model.services;

import java.util.List;
import java.util.Optional;

import cat.itacademy.barcelonactiva.barbero.yasmina.s05.t021.S05T02N01BarberoYasmina.model.domain.Game;
import cat.itacademy.barcelonactiva.barbero.yasmina.s05.t021.S05T02N01BarberoYasmina.model.domain.Player;



public interface GameService {

	public Game saveGame(Game game);
	public List<Game> findAll();
	public Game playGame(Long idPlayer);
	public boolean deleteGames(Long playerId);
	public Player updatePercent(Optional<Player> op);
	public List<Game> findGamesByPlayer(Long playerId);
	
}
