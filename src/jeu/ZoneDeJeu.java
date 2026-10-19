package jeu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cartes.Limite;
import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.DebutLimite;

public class ZoneDeJeu {
	private List<Limite> pileLimite;
	private List<Bataille> pileBataille;
	private Collection<Borne> collecBorne;
	
	public ZoneDeJeu() {
		this.pileLimite = new ArrayList<>();
		this.pileBataille = new ArrayList<>();
		this.collecBorne = new ArrayList<>();
	}
	
	public int donnerLimitationVitesse() {
		int limite = 200;
		if(!pileLimite.isEmpty() && pileLimite.getLast() instanceof DebutLimite) {
			limite = 50;
		}
		return limite;
	}
	
	public int donnerKmParcourus() {
		int kmParcourus = 0;
		
		for (Borne borne : collecBorne) {
			kmParcourus += borne.getKm();
		}
		
		return kmParcourus;
	}
	
	public void deposer(Carte c) {
		if(c instanceof Borne borne) {
			collecBorne.add(borne);
		} 
		else if(c instanceof Limite limite) {
			pileLimite.add(limite);
		}
		else if(c instanceof Bataille bataille){
			pileBataille.add(bataille);
		}
	}
}
















