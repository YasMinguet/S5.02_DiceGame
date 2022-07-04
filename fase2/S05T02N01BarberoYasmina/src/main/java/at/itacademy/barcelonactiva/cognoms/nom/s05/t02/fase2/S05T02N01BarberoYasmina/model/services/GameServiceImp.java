package at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.domain.Game;
import at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.domain.Player;
import at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.repository.GameRepository;
import at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.repository.PlayerRepository;

@Service
public class GameServiceImp implements GameService {
	
	@Autowired
	@Qualifier("gameRepository")
	GameRepository gameRepository;

	@Autowired
	@Qualifier("playerRepository")
	PlayerRepository playerRepository;
	
	@Transactional
	public Game saveGame(Game game) {

		return gameRepository.save(game);
	}
	
	@Transactional
	public List<Game> findAll() {

		return gameRepository.findAll();
	}
	
	@Transactional
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
	@Transactional
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
	
	@Transactional
	public Player updatePercent(Optional<Player> op) {
		double percent = op.get().perSuccess();
		op.get().setVictoryPercentage(percent);

		return playerRepository.save(op.get());

	}
	
	@Transactional
	public boolean deleteGames(Long playerId) {
		boolean exist = playerRepository.existsById(playerId);
		if (exist == true) {
			for (Game g : gameRepository.findAll()) {
				if (g.getPlayer().getIdPlayer() == playerId)
					gameRepository.delete(g);
			}
		}
		return true;

	}

}
