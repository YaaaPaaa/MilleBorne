package testsfonctionnels;

import java.util.ArrayList;

import jeu.Jeu;
import jeu.Joueur;
import jeu.MainJoueur;
import jeu.ZoneDeJeu;

public class TestJeu {
	public static void main(String[] args) {
		//Création des 3 joueurs
		ZoneDeJeu zoneJeu = new ZoneDeJeu();
		
		MainJoueur mainJack = new MainJoueur(new ArrayList<>());
		Joueur jack = new Joueur("Jack", zoneJeu, mainJack);
		
		MainJoueur mainBill = new MainJoueur(new ArrayList<>());
		Joueur bill = new Joueur("Bill", zoneJeu, mainBill);
		
		MainJoueur mainLuffy = new MainJoueur(new ArrayList<>());
		Joueur luffy = new Joueur("Luffy", zoneJeu, mainLuffy);
		
		//Création du jeu et lancement du jeu
		Jeu millesBornes = new Jeu();
		millesBornes.inscrire(jack, bill, luffy);
		millesBornes.distribuerCartes();
				
		//Chaque joueur joue une fois
		millesBornes.jouerTour(jack);
		millesBornes.jouerTour(bill);
		millesBornes.jouerTour(luffy);
	}
}
