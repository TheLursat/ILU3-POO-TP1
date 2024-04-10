package cartes;

import java.util.ArrayList;
import java.util.List;

import cartes.*;
import cartes.Probleme.Type;
import utils.Utils;

public class JeuDeCartes {
	private Carte[] typesDeCartes = { new Borne(10, 25), new Borne(10, 50), new Borne(10, 75), new Borne(12, 100),
            new Borne(4, 200), new Botte(1, Type.FEU), new Botte(1, Type.ESSENCE), new Botte(1, Type.CREVAISON),
            new Botte(1, Type.ACCIDENT), new Parade(Type.FEU, 14), new Parade(Type.ESSENCE, 6),
            new Parade(Type.CREVAISON, 6), new Parade(Type.ACCIDENT, 6), new Attaque(5, Type.FEU),
            new Attaque(3, Type.ESSENCE), new Attaque(3, Type.CREVAISON), new Attaque(3, Type.ACCIDENT),
            new DebutLimite(4), new FinLimite(6) }; 
	
	private List<Carte> listeCartes = new ArrayList<>();
	
	public JeuDeCartes() {
		for (Carte carte : typesDeCartes) {
			for(int i = 0; i < carte.getNombre();i++) {
				listeCartes.add(carte);
			}
		}
		listeCartes = Utils.melanger(listeCartes);
	}
	
	
	public List<Carte> getListeCartes(){
		return listeCartes;
	}
	
	public boolean checkCount() {
		if(listeCartes.size() != 106) {
			return false;
		}
		
		for (Carte carte : typesDeCartes) {
			int nb = 0;
			for(int i = 0 ; i < listeCartes.size(); i++) {
				if(carte.equals(listeCartes.get(i))) {
					nb++;
				}
			}
			if(nb != carte.getNombre()) {
				return false;
			}
		}
		return true;
	}

}
