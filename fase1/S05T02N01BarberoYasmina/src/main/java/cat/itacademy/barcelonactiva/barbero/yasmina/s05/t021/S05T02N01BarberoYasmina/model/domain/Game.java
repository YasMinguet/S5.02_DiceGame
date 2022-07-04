package cat.itacademy.barcelonactiva.barbero.yasmina.s05.t021.S05T02N01BarberoYasmina.model.domain;

import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name="Games")
public class Game {
	
	@Id
	@Column(name="Pk_GameId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGame;

	@Column(name = "Dice_1", updatable = false)
	private int dice1;

	@Column(name = "Dice_2", updatable = false)
	private int dice2;

	
	@Column(name = "Victory", updatable = false)
	private boolean win;

	
	
	@JoinColumn(name = "Pk_PlayerId")
	@JsonIgnore
	@ManyToOne(optional=false,cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
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