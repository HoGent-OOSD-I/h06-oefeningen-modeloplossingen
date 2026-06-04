package domein;

import java.util.ArrayList;
import java.util.List;

public class DomeinController {
	
	private List<Complex> complexeGetallen = new ArrayList<>();
	
	public void voegComplexGetalToe(double reeel, double imaginair) {
		complexeGetallen.add(new Complex(reeel, imaginair));
	}

	public List<String> geefAlleComplexeGetallen() {
		List<String> resultaat = new ArrayList<>();
		for (Complex complex : complexeGetallen) {
			resultaat.add(complex.toString());
		}
		return resultaat;
	}
	
	public String geefSomVanAlleComplexeGetallen() {
		return Complex.sommeer(complexeGetallen).toString();
	}
}
