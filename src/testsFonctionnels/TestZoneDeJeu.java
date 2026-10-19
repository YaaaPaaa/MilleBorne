package testsfonctionnels;

import cartes.Attaque;
import cartes.Borne;
//import cartes.Botte;
import jeu.Cartes;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Parade;
import cartes.Type;
import jeu.ZoneDeJeu;

public class TestZoneDeJeu {
	public static void main(String[] args) {
		// TP3 PARTIE 2
//		ZoneDeJeu zoneDeJeu = new ZoneDeJeu();
//		System.out.println("Deposer carte 25 km");
//		zoneDeJeu.deposer(new Borne(25));
//		System.out.println("Deposer carte 50 km");
//		zoneDeJeu.deposer(new Borne(50));
//		System.out.println("Deposer carte 75 km");
//		zoneDeJeu.deposer(new Borne(75));
//		System.out.println("Total des bornes : " + zoneDeJeu.donnerKmParcourus()); //Attendu : 150
//
//		String limite = "Limite : ";
//		System.out.println(limite + zoneDeJeu.donnerLimitationVitesse()); //Attendu : 200
//		zoneDeJeu.deposer(new DebutLimite());
//		System.out.println(limite + zoneDeJeu.donnerLimitationVitesse()); //Attendu : 50
//		zoneDeJeu.deposer(new FinLimite());
//		System.out.println(limite + zoneDeJeu.donnerLimitationVitesse()); //Attendu : 200

		// TP3 PARTIE 3
		boolean depotOK = false;
		String stringDepotOK = "depot ok ? ";
		String stringPeutAvancer = "peut avancer ? ";
		String attenduFaux = " (Attendu : false)";
		String attenduVrai = " (Attendu : true)";
		
		ZoneDeJeu zoneDeJeu = new ZoneDeJeu();
		// Feu rouge
		System.out.println("Deposer carte Feu rouge");
		depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_ROUGE);
		System.out.println(stringDepotOK + depotOK + attenduFaux);
		if (depotOK) {
			zoneDeJeu.deposer(Cartes.FEU_ROUGE);
		}
		System.out.println(stringPeutAvancer + zoneDeJeu.peutAvancer() + attenduFaux);
		// accident
		System.out.println("Deposer carte attaque - accident");
		depotOK = zoneDeJeu.estDepotAutorise(new Attaque(Type.ACCIDENT));
		System.out.println(stringDepotOK + depotOK + attenduFaux);
		if (depotOK) {
			zoneDeJeu.deposer(new Attaque(Type.ACCIDENT));
		}
		System.out.println(stringPeutAvancer + zoneDeJeu.peutAvancer() + attenduFaux);
		// Feu vert
		System.out.println("Deposer carte Feu vert");
		depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_VERT);
		System.out.println(stringDepotOK + depotOK + attenduVrai);
		if (depotOK) {
			zoneDeJeu.deposer(Cartes.FEU_VERT);
		}
		System.out.println(stringPeutAvancer + zoneDeJeu.peutAvancer() + attenduVrai);
		// panne d'essence
		System.out.println("Deposer carte attaque - essence");
		depotOK = zoneDeJeu.estDepotAutorise(new Attaque(Type.ESSENCE));
		System.out.println(stringDepotOK + depotOK + attenduVrai);
		if (depotOK) {
			zoneDeJeu.deposer(new Attaque(Type.ESSENCE));
		}
		System.out.println(stringPeutAvancer + zoneDeJeu.peutAvancer() + attenduFaux);
		// roue de secours
		System.out.println("Deposer carte parade - roue de secours");
		depotOK = zoneDeJeu.estDepotAutorise(new Parade(Type.CREVAISON));
		if (depotOK) {
			zoneDeJeu.deposer(new Parade(Type.CREVAISON));
		}
		System.out.println(stringDepotOK + depotOK + attenduFaux);
		System.out.println(stringPeutAvancer + zoneDeJeu.peutAvancer() + attenduFaux);
		// bidon d'essence
		System.out.println("Deposer carte parade - essence");
		depotOK = zoneDeJeu.estDepotAutorise(new Parade(Type.ESSENCE));
		if (depotOK) {
			zoneDeJeu.deposer(new Parade(Type.ESSENCE));
		}
		System.out.println(stringDepotOK + depotOK + attenduVrai);
		System.out.println(stringPeutAvancer + zoneDeJeu.peutAvancer() + attenduFaux);
		// Feu vert
		System.out.println("Deposer carte Feu vert");
		depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_VERT);
		System.out.println(stringDepotOK + depotOK + attenduVrai);
		if (depotOK) {
			zoneDeJeu.deposer(Cartes.FEU_VERT);
		}
		System.out.println(stringPeutAvancer + zoneDeJeu.peutAvancer() + attenduVrai);
		// D�pot 100 bornes
		System.out.println("Deposer carte borne - 100");
		depotOK = zoneDeJeu.estDepotAutorise(new Borne(100));
		System.out.println(stringDepotOK + depotOK + attenduVrai);
		if (depotOK) {
			zoneDeJeu.deposer(new Borne(100));
		}
		System.out.println(stringPeutAvancer + zoneDeJeu.peutAvancer() + attenduVrai);
		// D�pot limitation de vitesse 50 bornes
		System.out.println("Deposer carte limite - 50");
		depotOK = zoneDeJeu.estDepotAutorise(new DebutLimite());//TODO
		System.out.println(stringDepotOK + depotOK + attenduVrai);
		if (depotOK) {
			zoneDeJeu.deposer(new DebutLimite());
		}
		System.out.println(stringPeutAvancer + zoneDeJeu.peutAvancer() + attenduVrai);
		// D�pot 100 bornes
		System.out.println("Deposer carte borne - 100");
		depotOK = zoneDeJeu.estDepotAutorise(new Borne(100));
		System.out.println(stringDepotOK + depotOK + attenduFaux);
		if (depotOK) {
			zoneDeJeu.deposer(new Borne(100));
		}
		System.out.println(stringPeutAvancer + zoneDeJeu.peutAvancer() + attenduVrai);
		// Depot 25 bornes
		System.out.println("Deposer carte borne - 25");
		depotOK = zoneDeJeu.estDepotAutorise(new Borne(25));
		System.out.println(stringDepotOK + depotOK + attenduVrai);
		if (depotOK) {
			zoneDeJeu.deposer(new Borne(25));
		}
		System.out.println(stringPeutAvancer + zoneDeJeu.peutAvancer() + attenduVrai);
		// D�pot fin limitation
		System.out.println("Deposer carte fin limite - 50");
		depotOK = zoneDeJeu.estDepotAutorise(new FinLimite());
		System.out.println(stringDepotOK + depotOK + attenduVrai);
		if (depotOK) {
			zoneDeJeu.deposer(new FinLimite());
		}
		System.out.println(stringPeutAvancer + zoneDeJeu.peutAvancer() + attenduVrai);
		// D�pot 100 bornes
		System.out.println("Deposer carte borne - 100");
		depotOK = zoneDeJeu.estDepotAutorise(new Borne(100));
		System.out.println(stringDepotOK + depotOK + attenduVrai);
		if (depotOK) {
			zoneDeJeu.deposer(new Borne(100));
		}
		System.out.println(stringPeutAvancer + zoneDeJeu.peutAvancer() + attenduVrai);

// RESULTAT ATTENDU POUR LA PARTIE 3 (ne pas d�commenter)
// 			Deposer carte Feu rouge
//			d�p�t ok ? false
//			peut avancer ? false
//			Deposer carte attaque - accident
//			d�p�t ok ? false
//			peut avancer ? false
//			Deposer carte Feu vert
//			d�p�t ok ? true
//			peut avancer ? true
//			Deposer carte attaque - essence
//			d�p�t ok ? true
//			peut avancer ? false
//			Deposer carte parade - roue de secours
//			d�p�t ok ? false
//			peut avancer ? false
//			Deposer carte parade - essence
//			d�p�t ok ? true
//			peut avancer ? false
//			Deposer carte Feu vert
//			d�p�t ok ? true
//			peut avancer ? true
//			Deposer carte borne - 100
//			d�p�t ok ? true
//			peut avancer ? true
//			Deposer carte limite - 50
//			d�p�t ok ? true
//			peut avancer ? true
//			Deposer carte borne - 100
//			d�p�t ok ? false
//			peut avancer ? true
//			Deposer carte borne - 25
//			d�p�t ok ? true
//			peut avancer ? true
//			Deposer carte fin limite - 50
//			d�p�t ok ? true
//			peut avancer ? true
//			Deposer carte borne - 100
//			d�p�t ok ? true
//			peut avancer ? true

//		// TP4 Partie 1
//		boolean depotOK = false;
//		// Feu rouge
//		System.out.println("Deposer carte Feu rouge");
//		depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_ROUGE);
//		System.out.println("d�p�t ok ? " + depotOK);
//		if (depotOK) {
//			zoneDeJeu.deposer(Cartes.FEU_ROUGE);
//		}
//		System.out.println(stringPeutAvancer + zoneDeJeu.peutAvancer());
//		// Botte Vehicule prioritaire
//		System.out.println("Deposer carte Vehicule prioritaire");
//		depotOK = zoneDeJeu.estDepotAutorise(Cartes.PRIORITAIRE);
//		System.out.println("d�p�t ok ? " + depotOK);
//		if (depotOK) {
//			zoneDeJeu.deposer(Cartes.PRIORITAIRE);
//		}
//		System.out.println(stringPeutAvancer + zoneDeJeu.peutAvancer());
//		// accident
//		System.out.println("Deposer carte attaque - accident");
//		depotOK = zoneDeJeu.estDepotAutorise(new Attaque(Type.ACCIDENT));
//		System.out.println("d�p�t ok ? " + depotOK);
//		if (depotOK) {
//			zoneDeJeu.deposer(new Attaque(Type.ACCIDENT));
//		}
//		System.out.println(stringPeutAvancer + zoneDeJeu.peutAvancer());
//	
//		// botte roue de secours
//		System.out.println("Deposer botte - roue de secours");
//		depotOK = zoneDeJeu.estDepotAutorise(new Botte(Type.CREVAISON));
//		if (depotOK) {
//			zoneDeJeu.deposer(new Botte(Type.CREVAISON));
//		}
//		System.out.println("d�p�t ok ? " + depotOK);
//		System.out.println(stringPeutAvancer + zoneDeJeu.peutAvancer());
//		// botte as du volant
//		System.out.println("Deposer carte as du volant");
//		depotOK = zoneDeJeu.estDepotAutorise(new Botte(Type.ACCIDENT));
//		if (depotOK) {
//			zoneDeJeu.deposer(new Botte(Type.ACCIDENT));
//		}
//		System.out.println("d�p�t ok ? " + depotOK);
//		System.out.println(stringPeutAvancer + zoneDeJeu.peutAvancer());
//		// Feu vert
//		System.out.println("Deposer carte Feu vert");
//		depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_VERT);
//		System.out.println("d�p�t ok ? " + depotOK);
//		if (depotOK) {
//			zoneDeJeu.deposer(Cartes.FEU_VERT);
//		}
//		System.out.println(stringPeutAvancer + zoneDeJeu.peutAvancer());
//		// D�pot attaque accident
//		System.out.println("Deposer carte accident");
//		depotOK = zoneDeJeu.estDepotAutorise(new Attaque(Type.ACCIDENT));
//		System.out.println("d�p�t ok ? " + depotOK);
//		if (depotOK) {
//			zoneDeJeu.deposer(new Attaque(Type.ACCIDENT));
//		}
//		System.out.println(stringPeutAvancer + zoneDeJeu.peutAvancer());
//		// D�pot limitation de vitesse 50 bornes
//		System.out.println("Deposer carte limite - 50");
//		depotOK = zoneDeJeu.estDepotAutorise(new DebutLimite());
//		System.out.println("d�p�t ok ? " + depotOK);
//		if (depotOK) {
//			zoneDeJeu.deposer(new DebutLimite());
//		}
//		System.out.println(stringPeutAvancer + zoneDeJeu.peutAvancer());
		
		//RESULTAT ATTENDU POUR LE TP4 Partie 1
//		Deposer carte Feu rouge
//		d�p�t ok ? false
//		peut avancer ? false
//		Deposer carte Vehicule prioritaire
//		d�p�t ok ? true
//		peut avancer ? true
//		Deposer carte attaque - accident
//		d�p�t ok ? true
//		peut avancer ? false
//		Deposer botte - roue de secours
//		d�p�t ok ? true
//		peut avancer ? false
//		Deposer carte as du volant
//		d�p�t ok ? true
//		peut avancer ? true
//		Deposer carte Feu vert
//		d�p�t ok ? false
//		peut avancer ? true
//		Deposer carte accident
//		d�p�t ok ? false
//		peut avancer ? true
//		Deposer carte limite - 50
//		d�p�t ok ? false
//		peut avancer ? true
	}
}