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
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;
import cartes.Probleme.Type;

public class ZoneDeJeu {
	private List<Carte> pile_limites = new ArrayList<>();
	private List<Bataille> pile_bataille = new ArrayList<>();
	private List<Borne> pile_bornes = new ArrayList<>();
	private Set<Botte> bottes = new HashSet<>();

	public ZoneDeJeu() {
	}
	
	/**
	 * @return the pile_limites
	 */
	public List<Carte> getPile_limites() {
		return pile_limites;
	}

	/**
	 * @return the pile_bataille
	 */
	public List<Bataille> getPile_bataille() {
		return pile_bataille;
	}

	/**
	 * @return the pile_bornes
	 */
	public List<Borne> getPile_bornes() {
		return pile_bornes;
	}

	/**
	 * @return the bottes
	 */
	public Set<Botte> getBottes() {
		return bottes;
	}
	
	public void deposer(Borne borne) {
		pile_bornes.add(borne);
	}
	
	public void deposer(Limite limite) {
		pile_limites.add(0,limite);
	}
	
	public void deposer(Bataille bataille) {
		pile_bataille.add(0,bataille);
	}
	
	public void deposer(Botte botte) {
		bottes.add(botte);
	}
	
	
	
	public int donnerKmParcourus() {
		int sommeKm = 0;
		for( Borne borne : pile_bornes) {
			sommeKm += borne.getKm();
		}
		return sommeKm;
	}
	
	public int donnerLimitationVitesse() {
		if(bottes.contains(new Botte(1,Type.FEU))) {
			return 200;
		}
		if(pile_limites.isEmpty() || pile_limites.get(0) instanceof FinLimite) {
			return 200;
		}
		return 50;
	}
	
	public boolean estBloque() {
        Bataille sommet;
        Botte Prioritaire = new Botte(1, Type.FEU);
        Attaque feuRouge = new Attaque(1, Type.FEU);
        Parade feuVert = new Parade(Type.FEU, 1);
        boolean isPrioritaire = bottes.contains(Prioritaire);
        if (pile_bataille.isEmpty() && isPrioritaire) {
            return false;
        }

        else if (!pile_bataille.isEmpty()) {
            sommet = pile_bataille.get(0);
            Botte botteSommet = new Botte(1, sommet.getType());
            if (sommet.equals(feuVert)) {
                return false;
            }

            if (isPrioritaire) {

                if (sommet.equals(feuRouge)) {
                    return false;
                }
                
                else if (sommet instanceof Parade) {
                	return false;
                }

                else if (sommet instanceof Attaque && bottes.contains(botteSommet)) {
                    return false;
                }
            }

        }

        return true;
    }

}
