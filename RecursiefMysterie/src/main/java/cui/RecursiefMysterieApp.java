package cui;

public class RecursiefMysterieApp {

	/*
	private int mysterie(int a, int b) {
		if (b == 1)
			return a;
		return a + mysterie(a, b - 1);
	}*/
	
	 /*
	 Wat is het resultaat van de methode-aanroep mysterie(3, 4)?
		3 + mysterie(3,3)                                 = 3 + 9 = 12
            3 + mysterie(3,2)                 = 3 + 6 = 9
                3 + mysterie(3,1) = 3 + 3 = 6 
                    3
                    
     Kan je een algemene omschrijving geven van wat mysterie als resultaat heeft?
	 vermenigvuldiging: 3 x 4 = 12	

     Wat gebeurt er bij de methode aanroep mysterie(3, -4)?
	    Oneindige lus
	    Oplossing:*/
	private int mysterie(int a, int b) {
		if (b < 1)
			throw new IllegalArgumentException("ongeldig getal");
		if (b == 1)
			return a;
		else
			return a + mysterie(a, b - 1);
	}

}