package domein;

import utils.Orientatie;

public class Driehoek {
	public static final int MIN_GROOTTE = 1;
	public static final int MAX_GROOTTE = 20;
	public static final String TOEGESTANE_TEKENS = "#*$-@&|";

	private int grootte;
	private char teken;
	private Orientatie orientatie;

	public Driehoek(Orientatie orientatie, int grootte, char teken) {
		setGrootte(grootte);
		setTeken(teken);
		setOrientatie(orientatie);
	}

	public String geefAlsTekening() {
		return switch (orientatie) {
		case LINKS_BOVEN -> geefDriehoekLinksBoven();
		case LINKS_ONDER -> geefDriehoekLinksOnder();
		case RECHTS_BOVEN -> geefDriehoekRechtsBoven();
		case RECHTS_ONDER -> geefDriehoekRechtsOnder();
		};
	}

	private String geefDriehoekRechtsBoven() {
		String driehoek = "";
		for (int lijnNr = 1; lijnNr <= grootte; lijnNr++) {
			driehoek += geefTekensInString(' ', lijnNr - 1);
			driehoek += geefTekensInString(teken, grootte - lijnNr + 1);
			driehoek += "\n";
		}
		return driehoek;
	}

	private String geefDriehoekRechtsOnder() {
		String driehoek = "";
		for (int lijnNr = 1; lijnNr <= grootte; lijnNr++) {
			driehoek += geefTekensInString(' ', grootte - lijnNr);
			driehoek += geefTekensInString(teken, lijnNr);
			driehoek += "\n";
		}
		return driehoek;
	}

	private String geefDriehoekLinksBoven() {
		String driehoek = "";
		for (int lijnNr = 1; lijnNr <= grootte; lijnNr++) {
			driehoek += geefTekensInString(teken, grootte - lijnNr + 1);
			driehoek += "\n";
		}
		return driehoek;
	}

	private String geefDriehoekLinksOnder() {
		return geefDriehoekLinksOnderRecursief(grootte);
		// Niet recursief:
//		String driehoek = "";
//		for (int lijnNr = 1; lijnNr <= grootte; lijnNr++) {
//			driehoek += geefTekensInString(teken, lijnNr);
//			driehoek += "\n";
//		}
//		return driehoek;
	}

	private String geefDriehoekLinksOnderRecursief(int grootte) {
		if (grootte < 1)
			throw new IllegalArgumentException("ongeldige grootte");
		
		if (grootte == 1)
			return String.format("%s%n", teken); 
		
		String laatsteLijntje = String.format("%s%n", geefTekensInString(teken, grootte));
		return geefDriehoekLinksOnderRecursief(grootte - 1) + laatsteLijntje;
	}

	public void setGrootte(int grootte) {
		if (grootte < MIN_GROOTTE || grootte > MAX_GROOTTE)
			throw new IllegalArgumentException(
				String.format("Grootte moet in interval[%d, %d] liggen", 
						MIN_GROOTTE, MAX_GROOTTE));
		this.grootte = grootte;
	}

	public void setTeken(char teken) {
		if (TOEGESTANE_TEKENS.indexOf(teken) == -1)
			throw new IllegalArgumentException(
				String.format("Teken moet een van volgende karakters zijn: \"%s\"", 
						TOEGESTANE_TEKENS));
		this.teken = teken;
	}

	public void setOrientatie(Orientatie orientatie) {
		this.orientatie = orientatie;
	}

	private String geefTekensInString(char teken, int aantal) {
		String resultaat = "";
		for (int i = 0; i < aantal; i++) {
			resultaat += teken;
		}
		return resultaat;
	}
}
