package utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import cartes.Carte;

public class GestionCartes {
	public static <T> T extraire(List<T> liste) {
		T element;
		Random random = new Random();
        int randomElement = random.nextInt(liste.size());
        element = liste.get(randomElement);
        liste.remove(randomElement);
		return element;
	}
	
	//Pareil que extraire mais on exploite un ListIterator
	public static <T> T extraire2(ListIterator<T> liste) {
		int compteur = 0;
		while(liste.hasNext()) {
			liste.next();
			compteur++;
		}
		
		T element;
		Random random = new Random();
        int randomInt = random.nextInt(compteur);
        int randomElement = compteur - randomInt;
        
        while(0 < randomElement) {
        	liste.previous();
        	randomElement--;
        }
        
        element = liste.next();
        liste.remove();
		return element;
	}
	
	public static <T> List<T> melanger(List<T> liste) {
		List<T> nouvelleListe = new ArrayList<T>();
		
		while (!liste.isEmpty()) {
			nouvelleListe.add(extraire(liste));
		}
		
		return nouvelleListe;
	}
	
	public static <T> boolean verifierMelange(List<T> listeRepere, List<T> listeMelange) {
		if(listeRepere.size() != listeMelange.size()) {
			return false;
		}
		
		for (T t : listeRepere) {
			if(Collections.frequency(listeMelange, t) != Collections.frequency(listeRepere, t)) 
				return false;
		}
		
		return true;
	}
	
	public static <T> List<T> rassembler(List<T> liste) {
		List<T> nouvelleListe = new ArrayList<T>();
		
		while (!liste.isEmpty()) {
			T element = liste.remove(0);
			nouvelleListe.add(element);
			for (ListIterator<T> iterator = liste.listIterator(); iterator.hasNext();) {
				T t = (T) iterator.next();
				if(t.equals(element)) {
					nouvelleListe.add(t);
					iterator.remove();
				}
			}
		}
		
		return nouvelleListe;
	}

	public static <T> boolean verifierRassemblement(List<T> liste) {
		ListIterator<T> iterateur1 = liste.listIterator();
	    T precedent = iterateur1.next();
	    while (iterateur1.hasNext()) {
	        T courant = iterateur1.next();

	        if (!courant.equals(precedent)) {
	            ListIterator<T> iterateur2 = liste.listIterator(iterateur1.nextIndex());
	            while (iterateur2.hasNext()) {
	                T suivant = iterateur2.next();
	                if (suivant.equals(precedent)) {
	                    return false;
	                }
	            }
	            precedent = courant;
	        }
	    }
	    return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
