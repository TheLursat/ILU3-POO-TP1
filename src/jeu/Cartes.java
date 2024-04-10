package jeu;

import cartes.Attaque;
import cartes.Botte;
import cartes.Parade;
import cartes.Probleme.Type;

public interface Cartes {
	final Botte PRIORITAIRE = new Botte(1,Type.FEU);
	final Attaque FEU_ROUGE = new Attaque(1,Type.FEU);
	final Parade FEU_VERT = new Parade(Type.FEU,1);
	
		
}
