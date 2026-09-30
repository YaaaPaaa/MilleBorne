package testsFonctionnels;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Parade;
import cartes.Type;

public class TestMethodeEquals {
	
	public boolean questionA() {
		Borne borne1 = new Borne(25);
		Borne borne2 = new Borne(25);
		return borne1.equals(borne2);
	}
	
	public boolean questionB() {
		Bataille feuRouge1 = new Attaque(Type.FEU);
		Bataille feuRouge2 = new Attaque(Type.FEU);
		return feuRouge1.equals(feuRouge2);
	}
	
	public boolean questionC() {
		Bataille feuRouge = new Attaque(Type.FEU);
		Bataille feuVert = new Parade(Type.FEU);
		return feuRouge.equals(feuVert);
	}
	
	
	public static void main(String[] args) {
		TestMethodeEquals testPioche = new TestMethodeEquals();
		
		System.out.println("Deux cartes de 25km sont identiques ? " + testPioche.questionA());
		System.out.println("Deux cartes de feux rouge sont identiques ? " + testPioche.questionB());
		System.out.println("La carte feu rouge et la carte feu vert sont identiques ? " + testPioche.questionC());
	}
}
