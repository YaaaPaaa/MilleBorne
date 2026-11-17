package jeu;

import cartes.Attaque;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Parade;

public class Coup {
	private Joueur joueurCourant;
	private Carte carteJouee;
	private Joueur joueurCible;
	
	public Coup(Joueur joueurCourant, Carte carteJouee, Joueur joueurCible) {
		this.joueurCourant = joueurCourant;
		this.carteJouee = carteJouee;
		this.joueurCible = joueurCible; //Peut être null
	}
	
	public Joueur getJoueurCourant() {
		return joueurCourant;
	}
	
	public Carte getCarteJouee() {
		return carteJouee;
	}

	public Joueur getJoueurCible() {
		return joueurCible;
	}
	
	public boolean estValide() {
		if (joueurCible == null) {
			return true;
		}
	    
		if (carteJouee instanceof Attaque || carteJouee instanceof DebutLimite) {
			
	    	return !joueurCourant.equals(joueurCible);
	    }
	    
	    if (carteJouee instanceof Parade || carteJouee instanceof Botte || carteJouee instanceof Borne || carteJouee instanceof FinLimite) {
	    		return joueurCourant.equals(joueurCible);
	    }

	    return false;
	}
}
