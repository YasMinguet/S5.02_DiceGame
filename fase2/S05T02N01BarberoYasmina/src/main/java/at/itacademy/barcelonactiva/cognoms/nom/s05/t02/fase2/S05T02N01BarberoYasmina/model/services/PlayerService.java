package at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.domain.Player;

@Service
public interface PlayerService {
	
	public ArrayList<Player> getAllPlayers();
	public Player savePlayer(Player player);
	public Optional<Player> getPlayerById(Long id);
	public boolean deletePlayer(Long id);
	public Optional<Player> getBestPlayer();
	public Optional<Player> getWorstPlayer();
	public List<Player> getRanking();
	public Player checkName(Player player);

}
