package cui;

public class GetallenHerschikker {
	
	public static void herschikMetMutatie(int[] getallen) {
		int indexEerstePositiefGetal = geefIndexEerstePositiefGetal(getallen);
		int indexLaatsteNegatiefGetal = geefIndexLaatsteNegatiefGetal(getallen);

		while (indexEerstePositiefGetal < indexLaatsteNegatiefGetal) {
			wissel(getallen, indexEerstePositiefGetal, indexLaatsteNegatiefGetal);
			indexEerstePositiefGetal = geefIndexEerstePositiefGetal(getallen);
			indexLaatsteNegatiefGetal = geefIndexLaatsteNegatiefGetal(getallen);
		}
	}

	public static int[] herschikZonderMutatie(int[] getallen) {
		int[] deepCopyVanGetallen = new int[getallen.length];
		for (int i = 0; i < deepCopyVanGetallen.length; i++) {
			deepCopyVanGetallen[i] = getallen[i];
		}
		herschikMetMutatie(deepCopyVanGetallen);
		return deepCopyVanGetallen;
	}

	private static int geefIndexLaatsteNegatiefGetal(int[] getallen) {
		for (int index = getallen.length - 1; index >= 0; index--)
			if (getallen[index] < 0)
				return index;
		return -1;
	}

	private static int geefIndexEerstePositiefGetal(int[] getallen) {
		for (int index = 0; index < getallen.length; index++)
			if (getallen[index] >= 0)
				return index;
		return getallen.length;
	}

	private static void wissel(int[] getallen, int index1, int index2) {
		int temp = getallen[index1];
		getallen[index1] = getallen[index2];
		getallen[index2] = temp;
	}
}
