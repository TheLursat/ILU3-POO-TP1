package jeu;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Assert.*;


import cartes.Carte;

public class MainAsListe implements IMain {
	private List<Carte> cartesMain;

	public MainAsListe() {
		cartesMain =  new ArrayList<>();
	}

	@Override
	public void prendre(Carte carte) {
		cartesMain.add(carte);
	}

	@Override
	public void jouer(Carte carte) {
		assertTrue(cartesMain.contains(carte), "la carte n est pas dans la main");
		cartesMain.remove(carte);

	}
	
	public Iterator<Carte> iterateur(){
		Iterator<Carte> it = cartesMain.iterator();
		return it;
	}

	@Override
	public String toString() {
		return "La main contient : [" + cartesMain + "]";
	}

	
}
