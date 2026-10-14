package cartes;

public class Borne extends Carte {
	private int km;
	
	public Borne(int km) {
		this.km = km;
	}
	
	public int getKm() {
		return km;
	}
	
	@Override
	public String toString() {
		return km + "KM";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
	        return false;
	    }

	    Borne borne = (Borne) obj;
	    return getKm() == borne.getKm();
	}
	
	@Override
	public int hashCode() {
		return 31 * (getKm() + super.hashCode());
	}
}
