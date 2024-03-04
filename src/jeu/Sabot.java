package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot /*implements Iterable<Carte>*/ {
	private Carte[] tabCarte;
	private int nbCartes;
	private int nombreOperations = 0;

	public Sabot() {
		this.tabCarte = new Carte[110];
		this.nbCartes = 0;
	}
	
	public Boolean estVide() {
		if(this.nbCartes > 0) { 
			return false;
		}
		else return true;
	}

	private void ajouterCarte( Carte carte) throws ArrayIndexOutOfBoundsException {
		if(nbCartes < this.tabCarte.length) {
			this.tabCarte[this.nbCartes] = carte;
			this.nbCartes +=1;
		}else throw new ArrayIndexOutOfBoundsException("Le sabot est deja rempli");
	}
	
	public void ajouterFamilleCarte(Carte carte) {
		for(int i =0 ; i< carte.getNombre();i++) {
			ajouterCarte(carte);
		}
	}
	
	public void ajouterFamilleCarte(Carte... cartes ) {
		for (Carte carte : cartes) {
			ajouterFamilleCarte(carte);
		}
	}

	private class Iterateur implements Iterator<Carte>{
		private int indiceIterateur = 0;
		private int nombreOperationsReference = nombreOperations;
		private boolean nextEffectue = false;
		
		@Override
		public boolean hasNext() {
			return (this.indiceIterateur<nbCartes);
		}

		@Override
		public Carte next() {
			verificationConcurrence();
			if(hasNext()) {
				Carte carte = tabCarte[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				nombreOperations ++;
				nombreOperationsReference ++;
				return carte;
			}
			else {
				throw new NoSuchElementException();
			}
		}
		
		@Override
		public void remove() {
			if(nbCartes < 1 || !nextEffectue) {
				throw new IllegalStateException();
			}
			for(int i = indiceIterateur -1; i<nbCartes -1; i++) {
				tabCarte[i]=tabCarte[i+1];
			}
			nextEffectue = false;
			indiceIterateur --;
			nbCartes --;
			nombreOperations ++;
			nombreOperationsReference ++;
		}
		
		private void verificationConcurrence() {
			if(nombreOperations != nombreOperationsReference) {
				throw new ConcurrentModificationException();
			}
		}
	}
	
	public Carte piocher() {
		Iterateur iterateurPioche = new Iterateur();
		Carte cartePioche = iterateurPioche.next();
		iterateurPioche.remove();
		return cartePioche;
	}
}
