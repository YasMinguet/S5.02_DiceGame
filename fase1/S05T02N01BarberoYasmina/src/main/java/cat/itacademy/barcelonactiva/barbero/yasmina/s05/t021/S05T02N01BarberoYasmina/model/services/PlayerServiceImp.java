package cat.itacademy.barcelonactiva.barbero.yasmina.s05.t021.S05T02N01BarberoYasmina.model.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.barbero.yasmina.s05.t021.S05T02N01BarberoYasmina.model.domain.Player;
import cat.itacademy.barcelonactiva.barbero.yasmina.s05.t021.S05T02N01BarberoYasmina.model.repository.PlayerRepository;





@Service
public class PlayerServiceImp implements PlayerService {
	
	@Autowired
	PlayerRepository playerRepository;
	
	public ArrayList<Player> getAllPlayers(){
		
		return (ArrayList<Player>) playerRepository.findAll();
		
	}
	
	public Player savePlayer(Player player) {
		
		return playerRepository.save(player);
	}
	
	public Optional<Player> getPlayerById(Long id){
		
		return playerRepository.findById(id);
	}
	
	 public boolean deletePlayer(Long id) {
	        try{
	            playerRepository.deleteById(id);
	            return true;
	        }catch(Exception err){
	            return false;
	        }
	    }
	 
	 
	 
	 public Optional<Player> getBestPlayer() {

			List<Player> playerList = playerRepository.findAll();

			if (playerList.isEmpty()) {

				System.out.println("There are no players.");
			}

			Collections.sort(playerList, new ComparatorPlayer());

			System.out.println("The best player is: " + playerList.get(0).toString());

			return Optional.of(playerList.get(0));
		}
	 
	 
	 public Optional<Player> getWorstPlayer() {

			List<Player> playerList = playerRepository.findAll();

			if (playerList.isEmpty()) {

				System.out.println("There are no players.");
			}

			Collections.sort(playerList, new ComparatorPlayer());

			System.out.println("The worst player is: " + playerList.get(playerList.size() - 1).toString());

			return Optional.of(playerList.get(playerList.size() - 1));
		}

		
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
		
		public Player checkName(Player player) {
			List<Player>list=playerRepository.findAll();
			for(Player p:list) {
				if((p.getName().equalsIgnoreCase(player.getName())) || ((player.getName().equalsIgnoreCase("")))) {
					player.setName("Anónimo");

				}
				
			}
			return player;
			
		}

}
