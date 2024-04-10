package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Utils {
	static Random rand = new Random();

	public static <E> E extraire(List<E> liste) {
		if(liste.isEmpty()) {
			return null;
		}
		int index = rand.nextInt(liste.size());
		return liste.remove(index);
		
	}
	
	public static <E> E extraire2(List<E> liste) {
		int index = rand.nextInt(liste.size());
		E e = liste.get(0);
		for(ListIterator<E> it = liste.listIterator(); !it.hasNext() || it.nextIndex() > index;) {
			e = it.next();
		}
		liste.remove(index);
		return e;
		
	}
	
	
	public static <E> List<E>melanger(List<E> liste){
		int taille = liste.size();
		List <E> listeMelanger = new ArrayList<>();
		for(int i=0; i<taille;i++) {
			listeMelanger.add(extraire(liste));
		}
		return listeMelanger;
	}
	
	public static <E> boolean verifierMelange(List<E> listeOrigine, List<E> listeAVerifier){
		for(int i = 0; i < listeAVerifier.size(); i++) {
			if(Collections.frequency(listeAVerifier, listeOrigine.get(i)) != Collections.frequency(listeOrigine, listeOrigine.get(i))) {
				return false;
			}
		}
		//verifier pour liste2 par rapport a liste 1 avec un deuxieme for
		for(int i = 0; i < listeOrigine.size(); i++) {
			if(Collections.frequency(listeOrigine, listeAVerifier.get(i)) != Collections.frequency(listeAVerifier, listeAVerifier.get(i))) {
				return false;
			}
		}
		return true;
	}

	
	public static <E> List<E>rassembler(List<E> liste){
		List<E> liste2 = new ArrayList<>();
		for(int i =0; i< liste.size(); i++) {
			E elem = liste.get(i);
			if(!liste2.contains(elem)) {
				int num = Collections.frequency(liste, elem);
				for(int j = 0 ; j<num;j++) {
					liste2.add(elem);
				}
			}
		}
		return liste2;
	}
		
	
	public static <E> boolean searchElem(List<E> liste, E cur, int indice){
		for(ListIterator<E> it = liste.listIterator(indice); it.hasNext();) {
			E e = it.next();
			if(e.equals(cur)) {
				return true;
			}
		}
		return false;
	}
	
	
	public static <E> boolean verifierRassemblement(List <E> liste) {
		E precedent = liste.get(0);
		E current;
		for(ListIterator<E> it = liste.listIterator(); it.hasNext();) {
			current=it.next();
			if(!current.equals(precedent) && searchElem(liste, precedent, liste.indexOf(current))) {
				return false;
			}
			precedent = current;
		}
		return true;
		
	}
		
		
		
}
