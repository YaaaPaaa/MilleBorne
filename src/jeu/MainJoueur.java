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
		} else {
			throw new IllegalStateException();
		}
	}
	
	@Override
	public String toString() {
		StringBuilder chaine = new StringBuilder();
		chaine.append("Le joueur a dans sa main : [");
		for (Iterator<Carte> iterator = mainDuJoueur.iterator(); iterator.hasNext();) {
			Carte carte = iterator.next();
			chaine.append(carte.toString());
			chaine.append(", ");
		}
		chaine.setLength(chaine.length() - 2); //Pour enlenver le dernier ", "
		chaine.append("]");
		return chaine.toString();
	}

	@Override
	public Iterator<Carte> iterator() {
		return mainDuJoueur.iterator();
	}
}