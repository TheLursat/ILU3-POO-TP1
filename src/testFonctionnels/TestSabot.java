package testFonctionnels;

import cartes.*;
import cartes.Probleme.Type;
import jeu.Sabot;

public class TestSabot {

	public static void main(String[] args) {
		Sabot sabot = new Sabot();
		sabot.ajouterFamilleCarte(new Attaque(3, Type.ACCIDENT), new Parade(Type.ACCIDENT, 3),new Botte(1, Type.ACCIDENT) );
		while(!sabot.estVide()) {
			System.out.println(sabot.piocher());
		}
		
		/*Iterateur iterateur = new Iterateur();
		while(!sabot.estVide()) {
			iterateur.next();
			iterateur.remove();
		}*/
		
		sabot.piocher();
	}

}
