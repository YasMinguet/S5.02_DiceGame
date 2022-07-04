package cat.itacademy.barcelonactiva.barbero.yasmina.s05.t021.S05T02N01BarberoYasmina.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import cat.itacademy.barcelonactiva.barbero.yasmina.s05.t021.S05T02N01BarberoYasmina.model.domain.Player;




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
