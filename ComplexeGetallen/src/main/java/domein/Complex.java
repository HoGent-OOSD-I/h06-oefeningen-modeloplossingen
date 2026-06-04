package domein;

import java.util.List;

public class Complex {

	private final double reeel, imaginair;
    private static final double DEFAULT_WAARDE = 0.0;

	public Complex() {
		this(DEFAULT_WAARDE, DEFAULT_WAARDE);
	}

	public Complex(double reeel) {
		this(reeel, DEFAULT_WAARDE);
	}

	public Complex(double reeel, double imaginair) {
		this.reeel = reeel;
		this.imaginair = imaginair;
	}

	public double getReeel() {
		return reeel;
	}

	public double getImaginair() {
		return imaginair;
	}

	public Complex telOp(Complex c) {
		return new Complex(this.reeel + c.reeel, this.imaginair + c.imaginair);
	}

	public static Complex sommeer(List<Complex> getallen) {
		Complex som = new Complex();
		for (Complex complex : getallen) {
			som = som.telOp(complex);
		}
		return som;
	}

	@Override
	public String toString() {
		return String.format("%.2f %s %.2fi", this.reeel, this.imaginair >= 0 ? "+" : "-", Math.abs(imaginair));
	}
}
