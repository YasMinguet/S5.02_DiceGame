package cat.itacademy.barcelonactiva.barbero.yasmina.s05.t021.S05T02N01BarberoYasmina.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.barbero.yasmina.s05.t021.S05T02N01BarberoYasmina.model.domain.Game;
import cat.itacademy.barcelonactiva.barbero.yasmina.s05.t021.S05T02N01BarberoYasmina.model.domain.Player;
import cat.itacademy.barcelonactiva.barbero.yasmina.s05.t021.S05T02N01BarberoYasmina.model.repository.GameRepository;
import cat.itacademy.barcelonactiva.barbero.yasmina.s05.t021.S05T02N01BarberoYasmina.model.repository.PlayerRepository;

@Service
public class GameServiceImp implements GameService {

	@Autowired
	GameRepository gameRepository;

	@Autowired
	PlayerRepository playerRepository;

	public Game saveGame(Game game) {

		return gameRepository.save(game);
	}

	public List<Game> findAll() {

		return gameRepository.findAll();
	}

	public List<Game> findGamesByPlayer(Long playerId) {
		List<Game> list = gameRepository.findAll();
		List<Game> result = new ArrayList<Game>();
		for (Game g : list) {
			if (g.getPlayer().getIdPlayer() == playerId) {
				result.add(g);
			}

		}
		return result;
	}

	public Game playGame(Long playerId) {
		Optional<Player> op = playerRepository.findById(playerId);
		Game game = new Game();
		game.setPlayer(op.get());
		game.play();
		if (game.isWin()) {
			int result = op.get().getVictorys() + 1;
			op.get().setVictorys(result);
		}
		op.get().getGames().add(game);
		playerRepository.save(op.get());
		updatePercent(op);

		return gameRepository.save(game);
	}

	public Player updatePercent(Optional<Player> op) {
		double percent = op.get().perSuccess();
		op.get().setVictoryPercentage(percent);

		return playerRepository.save(op.get());

	}

	public boolean deleteGames(Long playerId) {
		boolean exist=playerRepository.existsById(playerId); 
		if(exist==true) {
			for (Game g:gameRepository.findAll()) {
				if(g.getPlayer().getIdPlayer()==playerId)
				gameRepository.delete(g);
			}
		}
		return true;
		

	}

}
