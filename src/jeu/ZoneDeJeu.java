package jeu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cartes.Limite;
import cartes.Bataille;
import cartes.Borne;

public class ZoneDeJeu {
	private List<Limite> pileLimite;
	private List<Bataille> pileBataille;
	private Collection<Borne> collecBorne;
	
	public ZoneDeJeu() {
		this.pileLimite = new ArrayList<>();
		this.pileBataille = new ArrayList<>();
		this.collecBorne = new ArrayList<>();
	}
}
