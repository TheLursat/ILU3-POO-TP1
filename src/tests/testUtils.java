package tests;

import java.util.ArrayList;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.Utils;

public class testUtils {

	public static void main(String[] args) {
	JeuDeCartes jeu = new JeuDeCartes();
	List<Carte> listeCarteNonMelangee = jeu.getListeCartes();
	List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
	System.out.println(listeCartes);
	listeCartes = Utils.melanger(listeCartes);
	System.out.println(listeCartes);
	System.out.println("liste mélangée sans erreur ? "+ Utils.verifierMelange(listeCarteNonMelangee, listeCartes));
	listeCartes = Utils.rassembler(listeCartes);
	System.out.println(listeCartes);
	System.out.println("liste rassemblée sans erreur ? " + Utils.verifierRassemblement(listeCartes));
	
	
	
	JeuDeCartes jeu2 = new JeuDeCartes();
	System.out.println("\n"+ jeu2.checkCount());
	
	
	
	}
}
