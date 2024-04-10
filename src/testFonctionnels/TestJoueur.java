package testFonctionnels;

import cartes.Borne;
import cartes.Botte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Probleme.Type;
import jeu.Joueur;

public class TestJoueur {

	public static void main(String[] args) {
		Joueur joueur = new Joueur("test");
		Borne borne100 = new Borne(1,100);
		Borne borne50 = new Borne(1,50);
		
		joueur.donner(borne100);
		joueur.donner(borne50);
		joueur.deposer(borne100);
		joueur.deposer(borne50);
		System.out.println(joueur.donnerKmParcourus());
		
		
		System.out.println(joueur.donnerLimitationVitesse());
		DebutLimite limite = new DebutLimite(1);
		joueur.deposer(limite);
		System.out.println(joueur.donnerLimitationVitesse());
		FinLimite finlimite = new FinLimite(1);
		joueur.deposer(finlimite);
		System.out.println(joueur.donnerLimitationVitesse());
		joueur.deposer(limite);
		Botte botte = new Botte(1,Type.FEU);
		Botte botte2 = new Botte(1,Type.ACCIDENT);
		joueur.deposer(botte);
		joueur.deposer(botte2);
		System.out.println(joueur.donnerLimitationVitesse());
		System.out.println(joueur.getZdj().getBottes());
	}

}
