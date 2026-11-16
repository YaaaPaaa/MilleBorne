package jeu;

import cartes.Attaque;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.Limite;
import cartes.Parade;

public class Coup {
	private Joueur joueurCourant;
	private Carte carteJouee;
	private Joueur joueurCible;
	
	public Coup(Joueur joueurCourant, Carte carteJouee, Joueur joueurCible) {
		this.joueurCourant = joueurCible;
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
		if (joueurCible == null) 
	    	return true;
	    if (carteJouee instanceof Attaque || carteJouee instanceof Limite) 
	    	return !joueurCible.equals(joueurCourant);
	    if (carteJouee instanceof Parade || carteJouee instanceof Botte || carteJouee instanceof Borne)
	        return joueurCible == joueurCourant;
	    return false;
	}
	
//	Un dépôt étant autorisé dans la zone ciblée, le joueur ne peut jouer une carte
//	d’attaque ou une limitation de vitesse que sur un autre joueur. Sinon il ne
//	peut la déposer que dans sa propre zone.
}
