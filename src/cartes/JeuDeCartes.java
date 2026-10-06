package cartes;

public class JeuDeCartes {
	private Configuration[] typesDeCartes = {
			new Configuration(new FinLimite(), 6),
			new Configuration(new DebutLimite(), 4),
			new Configuration(new Borne(25), 10),
			new Configuration(new Borne(50), 10),
			new Configuration(new Borne(75), 10),
			new Configuration(new Borne(100), 12),
			new Configuration(new Borne(200), 4),
			new Configuration(new Parade(Type.FEU), 14),
			new Configuration(new Parade(Type.ESSENCE), 6),
			new Configuration(new Parade(Type.CREVAISON), 6),
			new Configuration(new Parade(Type.ACCIDENT), 6),
			new Configuration(new Attaque(Type.FEU), 5),
			new Configuration(new Attaque(Type.ESSENCE), 3),
			new Configuration(new Attaque(Type.CREVAISON), 3),
			new Configuration(new Attaque(Type.ACCIDENT), 3),
			new Configuration(new Botte(Type.FEU), 1),
			new Configuration(new Botte(Type.ESSENCE), 1),
			new Configuration(new Botte(Type.CREVAISON), 1),
			new Configuration(new Botte(Type.ACCIDENT), 1)
	};
	
	public String affichageJeuDeCartes() {
		StringBuilder jeu = new StringBuilder();
		
		for (Configuration configuration : typesDeCartes) {
			jeu.append(configuration.getNbExemplaires());
			jeu.append(" ");
			jeu.append(configuration.getCarte());
			jeu.append("\n");
		}
		
		return jeu.toString();
	}
	
	public Carte[] donnerCartes() {
	    int nbCartes = 0;

	    for (Configuration configuration : typesDeCartes) {
	        nbCartes += configuration.getNbExemplaires();
	    }

	    Carte[] tabDeCarte = new Carte[nbCartes];

	    int compteur = 0;

	    for (Configuration configuration : typesDeCartes) {
	        for (int i = 0; i < configuration.getNbExemplaires(); i++) {
	            tabDeCarte[compteur] = configuration.getCarte();
	            compteur++;
	        }
	    }

	    return tabDeCarte;
	}

	
	public boolean checkCount() {
		Carte[] tabDeCarte = donnerCartes();
		
		for (Configuration configuration : typesDeCartes) {
			int nbCarteVoulu = configuration.getNbExemplaires();
			int nbCarteCompte = 0;
			for (int i = 0; i < tabDeCarte.length; i++) {
				if (tabDeCarte[i] != null && tabDeCarte[i].equals(configuration.getCarte())) {
				    nbCarteCompte++;
				}
			}
			if(nbCarteCompte != nbCarteVoulu) return false;
		}
		
		return true;
	}
	
	private static class Configuration {
		/*Avec static, on indique que Configuration appartient à la classe JeuDeCartes elle-même, 
		et non à une instance particulière de JeuDeCartes*/
		private int nbExemplaires;
		private Carte carte;
		
		private Configuration(Carte carte, int nbExemplaires) {
			this.nbExemplaires = nbExemplaires;
			this.carte = carte;
		}
		
		private Carte getCarte() {
			return carte;
		}
		
		private int getNbExemplaires() {
			return nbExemplaires;
		}
	}
}
