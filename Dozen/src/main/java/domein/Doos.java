package domein;

public class Doos {
	
	private final static String DEFAULT_KLEUR = "rood";
	private final static double DEFAULT_RIBBE = 1.0;
	private static int aantalDozenGemaakt;
	private double lengte, breedte, hoogte;
	private String kleur;
	private String code;

	public Doos() {
		this(DEFAULT_RIBBE, DEFAULT_RIBBE, DEFAULT_RIBBE, DEFAULT_KLEUR);
	}

	public Doos(String kleur) {
		this(DEFAULT_RIBBE, DEFAULT_RIBBE, DEFAULT_RIBBE, kleur);
	}

	public Doos(double lengte, double breedte, double hoogte) {
		this(lengte, breedte, hoogte, DEFAULT_KLEUR);
	}

	public Doos(double lengte, double breedte, double hoogte, String kleur) {
		setLengte(lengte);
		setBreedte(breedte);
		setHoogte(hoogte);
		setKleur(kleur);
		aantalDozenGemaakt++;
		stelCodeIn();
	}
	
	public double getLengte() {
		return lengte;
	}

	private void setLengte(double lengte) {
		controleerAfmeting("lengte", 0, lengte);
		this.lengte = lengte;
	}

	public double getBreedte() {
		return breedte;
	}

	private void setBreedte(double breedte) {
		controleerAfmeting("breedte", 0, breedte);
		this.breedte = breedte;
	}

	public double getHoogte() {
		return hoogte;
	}

	private void setHoogte(double hoogte) {
		controleerAfmeting("hoogte", 0, hoogte);
		this.hoogte = hoogte;
	}

	public String getKleur() {
		return kleur;
	}
	private void setKleur(String kleur) {
		if (kleur == null || kleur.isBlank()) {
			throw new IllegalArgumentException("Kleur moet een waarde hebben.");
		}
		this.kleur = kleur;
	}
	
	public static int getAantalDozenGemaakt() {
		return aantalDozenGemaakt;
	}
	
	public String getCode() {
		return code;
	}

	private void controleerAfmeting(String afmeting, 
			                      double minWaarde, double waarde) {
		if (waarde <= minWaarde) {
			throw new IllegalArgumentException(
					String.format("De %s moet groter dan %.1f zijn.", afmeting, minWaarde));
		}
	}

	private void stelCodeIn() {
		this.code = String.format("D%015d", aantalDozenGemaakt);
	}
}
