package jeu;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	private Sabot sabot;
	private Set<Joueur> joueurs;
	
	public Jeu() {
		// a. Récupère le tableau de cartes de la classe JeuDeCartes et les mélange, après transformation en liste listeCartes (Collections.addAll)
        JeuDeCartes jeuDeCartes = new JeuDeCartes();
        Carte[] tableauCartes = jeuDeCartes.donnerCartes();
        List<Carte> listeCartes = new ArrayList<>();
        Collections.addAll(listeCartes, tableauCartes);
        GestionCartes.melanger(listeCartes);
        
        // b. Crée le sabot avec en paramètre d’entrée le tableau des cartes mélangé, après transformation en tableau (listeCartes.toArray).
        Carte[] cartesMelangees = listeCartes.toArray(new Carte[0]);
        this.sabot = (new Sabot(cartesMelangees));
	}

	public Sabot getSabot() {
		return sabot;
	}
	
	public void inscrire(Joueur... participants) {
		Collections.addAll(joueurs, participants);
	}
	
	public void distribuerCartes() {
		final int NBCARTES = 6;
		
		for (int i = 0; i < NBCARTES; i++) {
			for (Joueur joueur : joueurs) {
				joueur.prendreCarte(sabot);
			}
		}
	}
}














