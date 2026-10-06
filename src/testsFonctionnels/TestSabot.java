package testsfonctionnels;

import java.util.Iterator;

import cartes.Botte;
import cartes.Carte;
import cartes.JeuDeCartes;
import jeu.Sabot;

public class TestSabot {
	JeuDeCartes jeu = new JeuDeCartes();
	Sabot sabot = new Sabot(jeu.donnerCartes());
	String jePioche = "Je pioche ";

	// 4.2.a
	public void questionA() {

		while (!sabot.estVide()) {
			Carte carte = sabot.piocher();
			System.out.println(jePioche + carte);
		}
//		Console :
//		Je pioche Accident
//		Je pioche Accident
//		Je pioche Accident
//		Je pioche R�paration
//		Je pioche R�paration
//		Je pioche R�paration
//		Je pioche As du volant
	}

	// 4.2.b
	public void questionB() {
		for (Iterator<Carte> iterator = sabot.iterator(); iterator.hasNext();) {
			System.out.println(jePioche + iterator.next());
			iterator.remove();
		}
		System.out.println("\nLe sabot est vide : " + sabot.estVide());
	}

	// 4.2.c
	public void questionC() {
		Carte cartePiochee = sabot.piocher();
		System.out.println(jePioche + cartePiochee);
		for (Iterator<Carte> iterator = sabot.iterator(); iterator.hasNext();) {
			Carte carte = iterator.next();
			System.out.println(jePioche + carte);
			iterator.remove();
			sabot.ajouterCarte(new Botte(cartes.Type.ACCIDENT));
		}
		Iterator<Carte> iterator = sabot.iterator();
		System.out.println("\nLa pioche contient encore des cartes ? " + iterator.hasNext());
	}

	public static void main(String[] args) {
		System.out.println("Test A :");
		TestSabot testA = new TestSabot();
		testA.questionA();
		
		System.out.println("\nTest B :");
		TestSabot testB = new TestSabot();
		testB.questionB();
		
		System.out.println("\nTest C :");
		TestSabot testC = new TestSabot();
		testC.questionC();
	}

}