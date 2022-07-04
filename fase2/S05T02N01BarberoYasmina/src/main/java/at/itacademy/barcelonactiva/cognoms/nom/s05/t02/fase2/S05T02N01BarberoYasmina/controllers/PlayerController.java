package at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.domain.Player;
import at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.services.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {

	@Autowired
	@Qualifier("playerService")
	PlayerService playerService;

	@GetMapping
	public ResponseEntity<?> getAll() {

		List<Player> players = StreamSupport.stream(playerService.getAllPlayers().spliterator(), false)
				.collect(Collectors.toList());

		return ResponseEntity.ok(players);
	}

	@PostMapping("/add")
	public ResponseEntity<?> savePlayer(@RequestBody Player player) {

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(playerService.savePlayer(playerService.checkName(player)));
	}

	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getPlayerById(@PathVariable("id") Long id) {

		Optional<Player> opPlayer = playerService.getPlayerById(id);

		if (!opPlayer.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(opPlayer);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Player player, @PathVariable Long id) {

		Optional<Player> opPlayer = playerService.getPlayerById(id);

		if (!opPlayer.isPresent()) {

			return ResponseEntity.notFound().build();
		}

		opPlayer.get().setName(player.getName());

		return ResponseEntity.status(HttpStatus.CREATED).body(playerService.savePlayer(opPlayer.get()));
	}

	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<?> deletePlayer(@PathVariable("id") Long id) {
		boolean ok = this.playerService.deletePlayer(id);
		if (ok) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/ranking/winner")
	public ResponseEntity<?> getBesttPlayer() throws Exception {

		Optional<Player> opPlayer = playerService.getBestPlayer();

		if (!opPlayer.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(opPlayer);
	}

	@GetMapping("/ranking")
	public ResponseEntity<?> getRanking() throws Exception {

		List<Player> players = StreamSupport.stream(playerService.getRanking().spliterator(), false)
				.collect(Collectors.toList());

		return ResponseEntity.ok(players);

	}

	@GetMapping("/ranking/loser")
	public ResponseEntity<?> getWorstPlayer() throws Exception {

		Optional<Player> opPlayer = playerService.getWorstPlayer();

		if (!opPlayer.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(opPlayer);
	}

}
