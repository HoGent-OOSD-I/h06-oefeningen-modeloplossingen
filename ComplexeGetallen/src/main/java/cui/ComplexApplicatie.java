package cui;

import java.util.List;
import java.util.Scanner;

import domein.DomeinController;

public class ComplexApplicatie {

	private DomeinController dc;
	private Scanner invoer;

	public ComplexApplicatie(DomeinController dc) {
		this.dc = dc;
		invoer = new Scanner(System.in);
	}

	public void start() {
		String antwoord = voerAntwoordIn();
		while (antwoord.equalsIgnoreCase("ja")) {
			voegGetalToe();
			toonAlleGetallen();
			invoer.nextLine();
			antwoord = voerAntwoordIn();
		}
		System.out.println("Tot een volgende keer!");
	}

	private String voerAntwoordIn() {
		String antwoord;
		boolean geldig;
		do {
			System.out.print("Wens je een complex getal toe te voegen (ja/nee)? ");
			antwoord = invoer.nextLine();
			geldig = antwoord.equalsIgnoreCase("ja") || antwoord.equalsIgnoreCase("nee");
			if (!geldig)
				System.out.println("Gelieve met ja of nee te antwoorden...");
		} while (!geldig);
		return antwoord;
	}

	private void voegGetalToe() {
		dc.voegComplexGetalToe(voegEenGetalToe("reele"), voegEenGetalToe("imaginaire"));
	}

	private double voegEenGetalToe(String deel)
	{
		System.out.printf("Geef het %s deel > ", deel);
		return invoer.nextDouble();
	}
	
	private void toonAlleGetallen() {
		List<String> getallen = dc.geefAlleComplexeGetallen();
		if (getallen.isEmpty()) {
			System.out.printf("Er zijn nog geen complexe getallen ingevoerd...%n%n");
		} else {
			System.out.printf("%nDe lijst van complexe getallen:%n");
			for (String getal : getallen) {
				System.out.printf("  %s%n", getal);
			}
			System.out.printf("De som van deze getallen is gelijk aan %s%n%n", 
					dc.geefSomVanAlleComplexeGetallen());
		}

	}
}
