package cui;

import java.util.Scanner;

public class TemperatuurStatusBisApplicatie {
	
	private Scanner invoer = new Scanner(System.in);

	private void bepaalTemperatuurStatus()
	{
		char schaal; 
		int temperatuur = voerTemperatuurIn();
		while (temperatuur != 9999) {
			schaal = voerSchaalIn();
			String resultaat = geefTemperatuurStatus(temperatuur, schaal);
			System.out.printf("%d graden %s voelt aan als %s%n%n", temperatuur,
					schaal == 'C' ? "Celcius" : "Fahrenheit",resultaat);
			temperatuur = voerTemperatuurIn();
		}
	}

	private String geefTemperatuurStatus(int temperatuur) {
		if (temperatuur < 10)
			return "koud";
		if (temperatuur <= 20)
			return "lauw";
		return "warm";
	}

	private String geefTemperatuurStatus(int temperatuur, char celOfFar) {
		if (celOfFar == 'F') {
			temperatuur = (temperatuur - 32) * 5 / 9;
		}
		return geefTemperatuurStatus(temperatuur);
	}

	private char voerSchaalIn() {
		int schaal;
		do {
			System.out.print("Geef de schaal - Celcius of Fahrenheit (C=1 of F=2): ");
			schaal = invoer.nextInt();
		} while (schaal != 1 && schaal != 2);
		return schaal == 1 ? 'C' : 'F';
	}

	private int voerTemperatuurIn() {
		System.out.print("Geef de temperatuur (9999 om te stoppen): ");
		return invoer.nextInt();

	}

	/**
	 * 
	 * @param args
	 */
	public static void main(java.lang.String[] args) {
		// TODO - implement TemperatuurStatusBisApplicatie.main
		throw new UnsupportedOperationException();
	}

	private void temperatuurStatus() {
		// TODO - implement TemperatuurStatusBisApplicatie.temperatuurStatus
		throw new UnsupportedOperationException();
	}
}
