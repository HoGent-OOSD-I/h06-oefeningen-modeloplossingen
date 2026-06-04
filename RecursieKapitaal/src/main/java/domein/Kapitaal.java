package domein;

public class Kapitaal {
	public static final double MIN_BEDRAG = 0, MIN_INTREST = 0, MAX_INTREST = 100;
	private double bedrag, intrest;

	public Kapitaal(double bedrag, double intrest) {
		setBedrag(bedrag);
		setIntrest(intrest);
	}

	public double getBedrag() {
		return bedrag;
	}

	public final void setBedrag(double bedrag) {
		if (bedrag < MIN_BEDRAG)
			throw new IllegalArgumentException("Bedrag moet positief zijn");
		this.bedrag = bedrag;
	}

	public double getIntrest() {
		return intrest;
	}

	public final void setIntrest(double intrest) {
		if (intrest < MIN_INTREST || intrest > MAX_INTREST)
			throw new IllegalArgumentException(
					String.format("Intrest moet in interval [%.0f, %.0f] liggen", MIN_INTREST, MAX_INTREST));
		this.intrest = intrest;
	}

	public double geefOpgebouwdKapitaal(int aantalJaar) {
		if (aantalJaar < 0)
			throw new IllegalArgumentException("aantal jaren moet positief zijn");
		if (aantalJaar == 0)
			return bedrag;
		return (1 + intrest / 100) * geefOpgebouwdKapitaal(aantalJaar - 1);
	}

}
