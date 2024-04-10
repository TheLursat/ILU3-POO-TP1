package cartes;

public abstract class Carte {
	private int nombre;
	
	protected Carte( int nombre) {
		this.nombre = nombre;
	}
	
	public int getNombre() {
		return nombre;
	}
	
	@Override
	public boolean equals(Object objet) {
		return(objet != null && objet.getClass()==getClass() );
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode()*31;
	}

}
