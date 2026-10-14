package jeu;

public class Joueur {
	String nom;
	ZoneDeJeu zoneJeu;
	
	public Joueur(String nom, ZoneDeJeu zoneJeu) {
		this.nom = nom;
		this.zoneJeu = zoneJeu;
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
}
