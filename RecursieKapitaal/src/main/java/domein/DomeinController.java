package domein;

import dto.KapitaalDTO;

public class DomeinController {

	private Kapitaal kapitaal;

	public void maakKapitaal(double startkapitaal, double intrest) {
		kapitaal = new Kapitaal(startkapitaal, intrest);
	}

	public void wijzigStartkapitaal(double startkapitaal) {
		kapitaal.setBedrag(startkapitaal);
	}

	public void wijzigIntrest(double intrest) {
		kapitaal.setIntrest(intrest);
	}

	public double geefOpgebouwdKapitaal(int aantalJaar) {
		return kapitaal.geefOpgebouwdKapitaal(aantalJaar);
	}

	public KapitaalDTO geefKapitaal() {
		return new KapitaalDTO(kapitaal.getBedrag(), kapitaal.getIntrest());
	}

}
