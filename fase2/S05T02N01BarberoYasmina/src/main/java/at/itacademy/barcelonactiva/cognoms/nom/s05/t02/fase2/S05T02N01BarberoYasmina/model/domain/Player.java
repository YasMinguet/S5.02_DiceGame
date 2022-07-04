package at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.domain;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;


@Document(collection="Players")
public class Player {
	
	@Id
    private Long idPlayer;
	private String name;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Calendar date;
	private double victoryPercentage;
	private int victorys;
	private List<Game> games; 
	
	
	
	
	public List<Game> getGames() {
		return games;
	}
	public void setGames(List<Game> games) {
		this.games = games;
		games.forEach(game-> game.setPlayer(this));
	}
	public Long getIdPlayer() {
		return idPlayer;
	}
	public void setIdPlayer(Long idPlayer) {
		this.idPlayer = idPlayer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public double getVictoryPercentage() {
		return victoryPercentage;
	}
	public void setVictoryPercentage(double victoryPercentage) {
		this.victoryPercentage = victoryPercentage;
	}
	public int getVictorys() {
		return victorys;
	}
	public void setVictorys(int victorys) {
		this.victorys = victorys;
	}
	
	public double perSuccess() {
		try {
		this.victoryPercentage= ((double)((this.victorys*100) / games.size()));
		}catch(ArithmeticException e){
			System.err.println("Warning: ArithmeticException");
		}
		return this.victoryPercentage;
		
	}
	
	
}
