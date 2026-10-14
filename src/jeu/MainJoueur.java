package jeu;

import java.util.Iterator;
import java.util.List;

import cartes.Carte;

public class MainJoueur implements Iterable<Carte>{
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
	
	@Override
	public String toString() {
		StringBuilder chaine = new StringBuilder();
		chaine.append("La main du joueur est :");
		for (Iterator<Carte> iterator = mainDuJoueur.iterator(); iterator.hasNext();) {
			Carte carte = iterator.next();
			chaine.append(carte.toString());
		}
		return chaine.toString();
	}

	@Override
	public Iterator<Carte> iterator() {
		return mainDuJoueur.iterator();
	}
}