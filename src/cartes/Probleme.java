package cartes;

public abstract class Probleme extends Carte {
	private Type type;
	
	public enum Type {
		FEU, ESSENCE, CREVAISON, ACCIDENT
	}

	protected Probleme(int nombre, Type type) {
		super(nombre);
		this.type = type;
	}

	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}
	
	@Override
	public boolean equals(Object objet) {
		if(super.equals(objet) ) {  // ecrire super a la place
			Probleme probleme = (Probleme) objet;
			return (type.equals(probleme.getType()));
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return getType().hashCode()*31;
	}
	
}
