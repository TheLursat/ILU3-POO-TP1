package cartes;

public abstract class Probleme extends Carte {
	private Type type;
	
	public enum Type {
		FEU, ESSENCE, CREVAISON, ACCIDENT
	}

	public Probleme(int nombre, Type type) {
		super(nombre);
		this.type = type;
	}

	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}
	
	
}
