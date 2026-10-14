package jeu;

import java.util.List;

import cartes.Carte;

public class MainJoueur {
	private List<Carte> mainDuJoueur;
	
	
	public MainJoueur(List<Carte> mainJoueur) {
		this.mainDuJoueur = mainJoueur;
	}
	
	public void prendre(Carte carte) {
		mainDuJoueur.add(carte);
	}
	
	public void jouer(Carte carte) {
		if(mainDuJoueur.contains(carte)) {
			mainDuJoueur.remove(carte);
		}
		
		throw new IllegalStateException();
	}
}
