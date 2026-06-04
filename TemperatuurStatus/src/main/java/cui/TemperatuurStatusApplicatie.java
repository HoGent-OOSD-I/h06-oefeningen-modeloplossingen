package cui;

import java.util.Scanner;

public class TemperatuurStatusApplicatie {

	public static void main(String[] args) {
		new TemperatuurStatusApplicatie().bepaalTemperatuurStatus();
	}
	
	private Scanner invoer = new Scanner(System.in);
	
	public void bepaalTemperatuurStatus()
	{
		String schaal = "Celsius";
		int temperatuur = voerTemperatuurIn();
		while (temperatuur != 9999) {
			String resultaat = geefTemperatuurStatus(temperatuur);
			System.out.printf("%d graden %s voelt aan als %s%n", temperatuur, schaal, resultaat);
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
	
	private int voerTemperatuurIn()
	{
		System.out.printf("Geef de temperatuur (9999 om te stoppen): ");
		return invoer.nextInt();
	}
	
}
