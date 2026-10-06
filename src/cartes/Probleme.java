package cartes;

public abstract class Probleme extends Carte {
	private Type type;
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Probleme probleme) {
			return toString().equals(probleme.toString());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	protected Probleme(Type type) {
		this.type = type;
	}

	public Type getType() {
		return type;
	}
}
