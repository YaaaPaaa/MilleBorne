package jeu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.Limite;

public class Joueur {
	private String nom;
	private ZoneDeJeu zoneJeu;
	private MainJoueur main;
	
	private static Random random = new Random();
	
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
	
	public MainJoueur getMain() {
		return main;
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
	
	public boolean estDepotAutorise(Carte carte) {
		return zoneJeu.estDepotAutorise(carte);
	}
	
	public Set<Coup> coupsPossible(Set<Joueur> participants){
		Set<Coup> ensembleCoupsValide = new HashSet<>();
		
		for (Joueur cible : participants) {
			for (Carte carte : main) {
				Coup coup = new Coup(this, carte, cible);
	            if (coup.estValide()) ensembleCoupsValide.add(coup);
			}
		}
		
		return ensembleCoupsValide;
	}
	
	public Set<Coup> coupsDefausse() {
	    Set<Coup> ensembleDefausses = new HashSet<>();

	    for (Carte carte : main) {
	        Coup coup = new Coup(this, carte, null);
	        ensembleDefausses.add(coup);
	    }

	    return ensembleDefausses;
	}
	
	public void retirerDeLaMain(Carte carte) {
		main.jouer(carte);
	}
	
	private Coup coupAleatoire(Set<Coup> ensembleCoup) {
		Coup coup = null;
        int randomElement = random.nextInt(ensembleCoup.size());
        Iterator<Coup> iterator = ensembleCoup.iterator();
        
        for (int i = 0; i < randomElement; i++) {
        	coup =  iterator.next();
		}
			
        ensembleCoup.remove(coup);
		return coup;
	}
	
	public Coup choisirCoup(Set<Joueur> participants) {
		Coup coup = null;
		
		Set<Coup> ensembleCoupsValide = coupsPossible(participants);
		if(!ensembleCoupsValide.isEmpty()) coup = coupAleatoire(ensembleCoupsValide);
		else {
			coup = coupAleatoire(coupsDefausse());
		}
		
		return coup;
	}
	
	public String afficherEtatJoueur() {
		StringBuilder affichageEtat = new StringBuilder();
		
		affichageEtat.append("L'ensemble des bottes :");
		for(Botte botte : zoneJeu.getBotte()) {
			affichageEtat.append("- ");
			affichageEtat.append(botte.toString());
		}
		affichageEtat.append("\n");
		
		List<Limite> pileLimite = zoneJeu.getLimite();
		affichageEtat.append(pileLimite.getLast() instanceof DebutLimite);
		affichageEtat.append("\n");
		 
		 affichageEtat.append(main.toString());
		
		return affichageEtat.toString();
	}
}


















