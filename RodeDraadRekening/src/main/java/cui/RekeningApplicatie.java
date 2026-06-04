package cui;

import java.math.BigDecimal;
import java.security.SecureRandom;

import domein.DomeinController;
import dto.RekeningDTO;

public class RekeningApplicatie {
	private DomeinController dc;
	private SecureRandom random;

	public RekeningApplicatie(DomeinController dc) {
		this.dc = dc;
		this.random = new SecureRandom();
	}

	public void start() {
		dc.voegRekeningToe(123123456712L, "Tamu");
		dc.voegRekeningToe(123456789012L, "Evelyn");
		dc.voegRekeningToe(101010101010L, "Mali", new BigDecimal(500));
		RekeningDTO[] alleRekeningen = dc.geefRekeningen();
		toonOverzicht(dc.geefRekeningen(), "=== Overzicht verse rekeningen ===");

		// op elke rekening wordt iets gestort
		for (int index = 0; index < alleRekeningen.length; index++) {
			BigDecimal bedrag = new BigDecimal(random.nextDouble(2000, 3000));
			System.out.printf("Op rekening #%d wordt %.2f gestort%n", index + 1, bedrag);
			dc.stort(index, bedrag);
		}
		toonOverzicht(dc.geefRekeningen(), "=== Overzicht na storten ===");

		// van elke rekening wordt iets afgehaald
		for (int index = 0; index < alleRekeningen.length; index++) {
			int tiental = 10 * random.nextInt(1, 10);
			BigDecimal bedrag = new BigDecimal(tiental);
			System.out.printf("Van rekening #%d wordt %.2f gehaald%n", index + 1, bedrag);
			dc.haalAf(index, bedrag);
		}
		toonOverzicht(dc.geefRekeningen(), "=== Overzicht na afhalen ===");

		// er wordt overgeschreven tussen verschillende rekeningen
		for (int index = 0; index < alleRekeningen.length; index++) {
			int honderdtal = 100 * random.nextInt(1, 10);
			BigDecimal bedrag = new BigDecimal(honderdtal);
			int indexNaar = (index + 1) % alleRekeningen.length;
			System.out.printf("Van rekening #%d wordt %.2f overgeschreven naar rekening #%d%n", index + 1, bedrag,
					indexNaar + 1);
			dc.schrijfOver(index, indexNaar, bedrag);
		}
		toonOverzicht(dc.geefRekeningen(), "=== Overzicht na overschrijven ===");
	}

	private void toonOverzicht(RekeningDTO[] alleRekeningen, String hoofding) {
		System.out.printf("%n%s%n", hoofding);
		for (RekeningDTO r : alleRekeningen) {
			System.out.printf("Rekening %d op naam van %s heeft saldo van %.2f%n", r.rekeningnummer(), r.houder(),
					r.saldo());
		}
		System.out.println();
	}
}
