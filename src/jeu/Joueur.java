package jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;
import cartes.Probleme.Type;

public class Joueur {
	private String nom;
	private ZoneDeJeu zdj = new ZoneDeJeu();
	private MainAsListe main = new MainAsListe();


	public Joueur(String nom) {
		this.nom = nom;
	}
	
	@Override
	public boolean equals(Object objet) {
		if(objet != null && getClass() == objet.getClass() ) {
			Joueur joueur = (Joueur) objet;
			return (nom.equals(joueur.nom));
		}
		return false;
	}

	@Override
	public String toString() {
		return getNom();
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return the zdj
	 */
	public ZoneDeJeu getZdj() {
		return zdj;
	}

	/**
	 * @return the main
	 */
	public MainAsListe getMain() {
		return main;
	}
	
	public void donner(Carte carte) {
		main.prendre(carte);
	}
	
	public Carte prendreCarte(List<Carte> sabot) {
		Carte carte;
		if(sabot.isEmpty()) {
			return null;
		}
		carte=sabot.remove(0);
		donner(carte);
		return carte;
	}
	
	public void deposer(Borne borne) {
		zdj.deposer(borne);
	}
	
	public void deposer(Limite limite) {
		zdj.deposer(limite);
	}
	
	public void deposer(Bataille bataille) {
		zdj.deposer(bataille);
	}
	
	public void deposer(Botte botte) {
		zdj.deposer(botte);
	}
	
	
	
	public int donnerKmParcourus() {
		return zdj.donnerKmParcourus();
	}
	
	public int donnerLimitationVitesse() {
		return zdj.donnerLimitationVitesse();
	}
	
	public boolean estBloque() {
       return zdj.estBloque();
    }
    
    
    
    
}
	


