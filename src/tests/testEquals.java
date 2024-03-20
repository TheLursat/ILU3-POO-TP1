package tests;

import cartes.*;
import cartes.Probleme.Type;

public class testEquals {

	public static void main(String[] args) {
		Borne borne1 = new Borne(1, 100);
		Borne borne2 = new Borne(1, 50);
		Borne borne3 = new Borne(1, 100);

		System.out.println(borne1.equals(borne2) + " " + borne1.equals(borne3));

		DebutLimite dlim = new DebutLimite(1);
		DebutLimite dlim2 = new DebutLimite(1);
		FinLimite flim = new FinLimite(1);

		System.out.println(dlim.equals(dlim2) + " " + dlim.equals(flim));

		Botte botte1 = new Botte(1, Type.ACCIDENT);
		Botte botte2 = new Botte(1, Type.ACCIDENT);
		Botte botte3 = new Botte(1, Type.CREVAISON);

		System.out.println(botte1.equals(botte3) + " " + botte1.equals(botte2));

		Parade parade1 = new Parade(Type.ACCIDENT, 1);
		Parade parade2 = new Parade(Type.ACCIDENT, 1);
		Attaque attaque1 = new Attaque(1, Type.ACCIDENT);

		System.out.println(parade1.equals(parade2) + " " + parade1.equals(attaque1));
	}

}
