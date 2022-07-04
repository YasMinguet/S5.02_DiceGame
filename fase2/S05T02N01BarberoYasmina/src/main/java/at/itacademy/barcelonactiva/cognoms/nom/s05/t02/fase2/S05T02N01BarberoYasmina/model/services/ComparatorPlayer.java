package at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.services;

import java.util.Comparator;

import at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.domain.Player;

public class ComparatorPlayer implements Comparator<Player> {
	@Override
	public int compare(Player o1, Player o2) {
		//retornamos positivo para que quede detrás(1), negativo para que quede delante y 0 para igual
		    return o2.getVictoryPercentage() < o1.getVictoryPercentage() ? -1 :  o2.getVictoryPercentage()== o1.getVictoryPercentage() ? 0 : 1;
}}