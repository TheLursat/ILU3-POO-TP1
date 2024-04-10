package testFonctionnels;

import cartes.Attaque;
import cartes.Botte;
import cartes.Parade;
import cartes.Probleme.Type;
import jeu.Cartes;
import jeu.Joueur;

public class TestZoneDeJeu {

	public static void main(String[] args) {
		
		Joueur joueur = new Joueur("J1");

        Attaque accident = new Attaque(1, Type.ACCIDENT);
        Attaque panneEssence = new Attaque(1, Type.ESSENCE);
        Parade essence = new Parade(Type.ESSENCE, 1);
        Botte asDuVolant = new Botte(1, Type.ACCIDENT);

        System.out.println(joueur.estBloque());
        joueur.deposer(Cartes.FEU_VERT);
        System.out.println(joueur.estBloque());
        joueur.deposer(Cartes.FEU_ROUGE);
        System.out.println(joueur.estBloque());
        joueur.deposer(Cartes.PRIORITAIRE);
        System.out.println(joueur.estBloque());
        joueur.deposer(accident);
        System.out.println(joueur.estBloque());
        joueur.deposer(asDuVolant);
        System.out.println(joueur.estBloque());
        joueur.deposer(panneEssence);
        System.out.println(joueur.estBloque());
        joueur.deposer(essence);
        System.out.println(joueur.estBloque());
	}

}
