package at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.domain;

import java.util.Optional;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Document(collection="Games")
public class Game {
	
	@Id
	private Long idGame;
	private int dice1;
	private int dice2;
	private boolean win;
	//@JsonIgnore
	private Player player;

	

	public Game(Long idGame, int dice1, int dice2, boolean win, Player player) {

		this.idGame = idGame;
		this.dice1 = dice1;
		this.dice2 = dice2;
		this.win = win;
		this.player = player;
	}

	public Game(Player player) {
		this.player = player;
	}

	public Game(Optional<Player> player) {

	}
	
	public Game () {
		
	}

	public Long getIdGame() {
		return idGame;
	}

	public void setIdGame(Long idGame) {
		this.idGame = idGame;
	}

	public int getDice1() {
		return dice1;
	}

	public void setDice1(int dice1) {
		this.dice1 = dice1;
	}

	public int getDice2() {
		return dice2;
	}

	public void setDice2(int dice2) {
		this.dice2 = dice2;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	

	public void play() {
		this.win=false;
		this.dice1=(int) Math.floor(Math.random()*6+1);
		this.dice2=(int) Math.floor(Math.random()*6+1);
		int result=dice1+dice2;
	
		if(result==7) {
			this.win=true;
		}
	}
	
}