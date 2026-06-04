package cui;

public class CallChainApp03 {

	public static void main(String[] args) {
		new CallChainApp03().methodeA();
	}

	private void methodeA() {
		methodeB();
		System.out.println("Start A");
		System.out.println("Beeindig A");
	}

	private void methodeB() {
		System.out.println("Start B");
		System.out.println("Beeindig B");
		methodeC();
	}

	private void methodeC() {
		System.out.println("Start C");
		System.out.println("Beeindig C");
	}

}
