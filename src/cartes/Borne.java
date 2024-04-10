package cartes;

public class Borne extends Carte {
	private int km;

	public Borne(int nombre, int km) {
		super(nombre);
		this.km = km;
	}

	/**
	 * @return the km
	 */
	public int getKm() {
		return km;
	}

	@Override
	public String toString() {
		return "Borne [" + km + "]";
	}
	
	@Override
	public boolean equals(Object objet) {
		if(objet instanceof Borne borne ) {
			return km==borne.getKm();
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return km*31+super.hashCode();
	}

}
