package at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.domain.Player;
import at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.repository.PlayerRepository;

@Service
public class PlayerServiceImp implements PlayerService {

	@Autowired
	@Qualifier("playerRepository")
	PlayerRepository playerRepository;
	
	@Transactional
	public ArrayList<Player> getAllPlayers() {

		return (ArrayList<Player>) playerRepository.findAll();

	}
	
	@Transactional
	public Player savePlayer(Player player) {

		return playerRepository.save(player);
	}
	
	@Transactional
	public Optional<Player> getPlayerById(Long id) {

		return playerRepository.findById(id);
	}
	
	@Transactional
	public boolean deletePlayer(Long id) {
		try {
			playerRepository.deleteById(id);
			return true;
		} catch (Exception err) {
			return false;
		}
	}
	
	@Transactional
	public Optional<Player> getBestPlayer() {

		List<Player> playerList = playerRepository.findAll();

		if (playerList.isEmpty()) {

			System.out.println("There are no players.");
		}

		Collections.sort(playerList, new ComparatorPlayer());

		System.out.println("The best player is: " + playerList.get(0).toString());

		return Optional.of(playerList.get(0));
	}
	
	@Transactional
	public Optional<Player> getWorstPlayer() {

		List<Player> playerList = playerRepository.findAll();

		if (playerList.isEmpty()) {

			System.out.println("There are no players.");
		}

		Collections.sort(playerList, new ComparatorPlayer());

		System.out.println("The worst player is: " + playerList.get(playerList.size() - 1).toString());

		return Optional.of(playerList.get(playerList.size() - 1));
	}
	
	@Transactional
	public List<Player> getRanking() {

		List<Player> playerList = playerRepository.findAll();

		List<Player> playerRanking = new ArrayList<Player>();

		if (playerList.isEmpty()) {

			System.out.println("There are no players.");
		}

		else {

			Collections.sort(playerList, new ComparatorPlayer());

			for (Player player : playerList) {

				playerRanking.add(player);

			}

		}
		return playerRanking;
	}
	
	@Transactional
	public Player checkName(Player player) {
		List<Player> list = playerRepository.findAll();
		for (Player p : list) {
			if ((p.getName().equalsIgnoreCase(player.getName())) || ((player.getName().equalsIgnoreCase("")))) {
				player.setName("Anónimo");

			}

		}
		return player;

	}

}
