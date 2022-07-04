package cat.itacademy.barcelonactiva.barbero.yasmina.s05.t021.S05T02N01BarberoYasmina.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.barbero.yasmina.s05.t021.S05T02N01BarberoYasmina.model.domain.Game;
import cat.itacademy.barcelonactiva.barbero.yasmina.s05.t021.S05T02N01BarberoYasmina.model.services.GameService;
import cat.itacademy.barcelonactiva.barbero.yasmina.s05.t021.S05T02N01BarberoYasmina.model.services.PlayerService;



@RestController
@RequestMapping("/players/{id}/games/")
public class GameController {

	@Autowired
	GameService gameService;

	@Autowired
	PlayerService playerService;

	@GetMapping
	public ResponseEntity<?> findGamesByPlayer(@PathVariable("id") Long id) {

		List<Game> games = StreamSupport.stream(gameService.findGamesByPlayer(id).spliterator(), false)
				.collect(Collectors.toList());

		return ResponseEntity.ok(games);
	}

	@PostMapping
	public ResponseEntity<?> playGame(@PathVariable("id") Long id) {

		return ResponseEntity.status(HttpStatus.CREATED).body(gameService.playGame(id));

	}

	@DeleteMapping
	public ResponseEntity<?> deleteGames(@PathVariable("id") Long id) {
		boolean ok = gameService.deleteGames(id);
		if (ok==true) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
