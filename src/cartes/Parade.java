package cartes;

public class Parade extends Bataille {

	public Parade(Type type, int nombre) {
		super(nombre, type);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		switch(this.getType()){
		case FEU:
			return "Feu vert";
		case ESSENCE:
			return "Essence";
		case CREVAISON:
			return "Roue de secours";
		case ACCIDENT :
			return "Reparations";
		}
		return "";
		
	}

}
