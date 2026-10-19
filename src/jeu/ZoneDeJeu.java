package jeu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cartes.Limite;
import cartes.Parade;
import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;

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
	
	public boolean peutAvancer() {
		return !pileBataille.isEmpty() && pileBataille.getLast().equals(Cartes.FEU_VERT);
	}
	
	private boolean estDepotFeuVertAutorise() {
		System.out.println("FEUVERT");
		return pileBataille.isEmpty() 
				|| pileBataille.getLast().equals(Cartes.FEU_ROUGE)
				|| ((pileBataille.getLast() instanceof Parade) 
					&& !pileBataille.getLast().equals(Cartes.FEU_VERT));
	}
	
	private boolean estDepotBorneAutorise(Borne borne) {
		return peutAvancer()
				&& borne.getKm() <= donnerLimitationVitesse()
				&& donnerKmParcourus() + borne.getKm() < 1000;
	}
	
	private boolean estDepotLimiteAutorise(Limite limite) {
		if(limite instanceof DebutLimite){
			return pileLimite.isEmpty()
					|| pileLimite.getLast() instanceof FinLimite;
		}
		return !pileLimite.isEmpty()
				&& pileLimite.getLast() instanceof DebutLimite;
	}
	
	private boolean estDepotBatailleAutorise(Bataille bataille) {
		if(bataille instanceof Attaque) {
			return peutAvancer();
		}
		if(bataille.equals(Cartes.FEU_VERT)) {
			return pileBataille.isEmpty()
					|| pileBataille.getLast().equals(Cartes.FEU_ROUGE)
					|| ((pileBataille.getLast() instanceof Parade) 
							&& !pileBataille.getLast().equals(Cartes.FEU_VERT));
		}
		return !pileBataille.isEmpty()
				&& (pileBataille.getLast() instanceof Attaque
						&& pileBataille.getLast().getType().equals(bataille.getType()));
	}
	
	public boolean estDepotAutorise(Carte carte) {
		if(carte instanceof Borne borne) return estDepotBorneAutorise(borne);
		else if(carte instanceof Limite limite) return estDepotLimiteAutorise(limite);
		else if(carte instanceof Bataille bataille) return estDepotBatailleAutorise(bataille);
		return estDepotFeuVertAutorise();
	}
}
















