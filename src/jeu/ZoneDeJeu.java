package jeu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import cartes.Limite;
import cartes.Parade;
import cartes.Type;
import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;

public class ZoneDeJeu {
	private List<Limite> pileLimite;
	private List<Bataille> pileBataille;
	private Collection<Borne> collecBorne;
	private HashSet<Botte> ensembleBottes;
	
	public ZoneDeJeu() {
		this.pileLimite = new ArrayList<>();
		this.pileBataille = new ArrayList<>();
		this.collecBorne = new ArrayList<>();
	}
	
	public int donnerLimitationVitesse() {
		int limite = 200;
		
		if(estPrioritaire()) return limite;
		
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
		else if(c instanceof Botte botte) {
			ensembleBottes.add(botte);
		}
	}
	
	//Fonction auxiliaire permettant de savoir si il existe une botte du même type que l'argument donné
	private boolean estBotteTypeEquivalent(Type type) {
		for (Botte botte : ensembleBottes) {
			if(botte.getType().equals(type)) return true;
		}
		return false;
	}
	
	public boolean peutAvancer() {
		boolean pileBatailleVide = pileBataille.isEmpty();
		boolean estPrio = estPrioritaire();
		if(pileBatailleVide && estPrio) return true;
		
		if(!pileBatailleVide) {
			Bataille sommet = pileBataille.getLast();
			Type typeSommet = sommet.getType();
			
			return sommet.equals(Cartes.FEU_VERT)
				|| estPrio && (sommet instanceof Parade
								//A partir d'ici on suppose que le sommet est une Attaque car ce n'est pas une Parade
								|| typeSommet.equals(Type.FEU)
						   		|| estBotteTypeEquivalent(typeSommet));
				
		}
		return false;
	}
	
	private boolean estDepotFeuVertAutorise() {
		System.out.println("FEUVERT");
		
		if(estPrioritaire()) return false;
		if(pileBataille.isEmpty()) return true;
		
		Bataille sommet = pileBataille.getLast();
		return sommet.equals(Cartes.FEU_ROUGE)
			|| ((sommet instanceof Parade)
					&& !sommet.equals(Cartes.FEU_VERT))
			|| ((sommet instanceof Attaque)
					&& estBotteTypeEquivalent(sommet.getType()));
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

	public boolean estPrioritaire() {
		boolean estPrio = false;
		
		for(Botte botte : ensembleBottes) {
			if(botte.equals(Cartes.PRIORITAIRE)) estPrio = true;
		}
		
		return estPrio;
	}
}
















