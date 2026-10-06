package cartes;

public class Borne extends Carte {
	private int km;
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Borne borne) {
			return getKm() == borne.getKm();
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	public Borne(int km) {
		this.km = km;
	}
	
	public int getKm () {
		return km;
	}
	
	@Override
	public String toString() {
		return km + "KM";
	}
}
