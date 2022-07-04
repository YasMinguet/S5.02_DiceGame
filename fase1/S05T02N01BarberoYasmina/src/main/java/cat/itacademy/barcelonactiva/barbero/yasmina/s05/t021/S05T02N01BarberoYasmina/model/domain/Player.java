package cat.itacademy.barcelonactiva.barbero.yasmina.s05.t021.S05T02N01BarberoYasmina.model.domain;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="Players")
public class Player {

	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Pk_PlayerId")
    private Long idPlayer;
	@Column(name = "Name", length = 100)
	private String name;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Column(name = "Registration_date")
	private Calendar date;
	@Column(name = "Victory_Percentage")
	private double victoryPercentage;
	@Column(name = "Total_Victory")
	private int victorys;
	
	
	@OneToMany(mappedBy="player", cascade=CascadeType.REMOVE)
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
