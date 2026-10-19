package jeu;

import cartes.Carte;

public class Joueur {
	private String nom;
	private ZoneDeJeu zoneJeu;
	private MainJoueur main;
	
	public Joueur(String nom, ZoneDeJeu zoneJeu, MainJoueur main) {
		this.nom = nom;
		this.zoneJeu = zoneJeu;
		this.main = main;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Joueur joueur) {
			return nom.equals(joueur.nom);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 31 * nom.hashCode();
	}
	
	@Override
	public String toString() {
		return nom;
	}
	
	public void donner(Carte carte) {
		main.prendre(carte);
	}
	
	public Carte prendreCarte(Sabot sabot) {
		Carte carte = null;
		if(!sabot.estVide()) {
			carte = sabot.piocher();
			donner(carte);
		}
		return carte;
	}
	
	public int donnerKmParcourus() {
		return zoneJeu.donnerKmParcourus();
	}
	
	public void deposer(Carte c) {
		zoneJeu.deposer(c);
	}
}


















