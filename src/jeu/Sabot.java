package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;
import cartes.JeuDeCartes;

public class Sabot implements Iterable<Carte> {
	private Carte[] sabot;
	private int nbCartes;
	private int nbOperations = 0;
	
	public Sabot() {
		JeuDeCartes jeu = new JeuDeCartes();
		
		this.sabot = jeu.donnerCartes();
		this.nbCartes = sabot.length;
	}
	
	public boolean estVide() {
		return nbCartes == 0;
	}
	
	public Carte[] ajouterCarte(Carte carteAjoute) {
		for (int i = 0; i < sabot.length; i++) {
            if (sabot[i] == null) {
            	sabot[i] = carteAjoute;
                nbCartes++;
                nbOperations++;
                return sabot;
            }
        }
        throw new IllegalStateException("Capacité maximale atteinte : impossible d'ajouter la carte.");
	}

	@Override
	public Iterator<Carte> iterator() {
		return new Iterateur();
	}
	
	private class Iterateur implements Iterator<Carte>{
		private int nbOperationReference = nbOperations;
		private boolean nextEffectue = false;
		private int indiceIterateur = 0;

		@Override
		public boolean hasNext() {
			return indiceIterateur < nbCartes;
		}

		@Override
		public Carte next() {
			if(hasNext()) {
				Carte carte = sabot[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				return carte;
			} else throw new NoSuchElementException();
		}
		
		@Override
		public void remove() {
			verificationConcurrence();
			if(nbCartes < 1 || !nextEffectue) throw new IllegalStateException();
			
			for (int i = indiceIterateur - 1; i < nbCartes - 1; i++) {
				sabot[i] = sabot[i + 1];
			}
			nextEffectue = false;
			indiceIterateur--;
			nbCartes--;
			
			nbOperationReference++;
			nbOperations++;
		}
		
		private void verificationConcurrence(){
			if (nbOperations != nbOperationReference)
			throw new ConcurrentModificationException();
		}
	}
}
