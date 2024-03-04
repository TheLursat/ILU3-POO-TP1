package testFonctionnels;

import java.util.Iterator;

import cartes.*;
import cartes.Probleme.Type;
import jeu.Sabot;

public class TestSabot {

	public static void main(String[] args) {
		Sabot sabot = new Sabot();
		sabot.ajouterFamilleCarte(new Attaque(3, Type.ACCIDENT), new Parade(Type.ACCIDENT, 3),new Botte(1, Type.ACCIDENT) );
		
//		while(!sabot.estVide()) {
//			System.out.println(sabot.piocher());
//		}
		
		for (Iterator<Carte> iterator = sabot.iterator(); iterator.hasNext();) {
			Carte carte = (Carte) iterator.next();
			System.out.println("Je pioche "+carte.toString());
			iterator.remove();
			
		}
		
//		sabot.piocher();
//		sabot.ajouterFamilleCarte(new Botte(1, Type.ACCIDENT));
	}

}
