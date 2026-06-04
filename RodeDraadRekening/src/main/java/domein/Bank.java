package domein;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bank {
	
	private List<Rekening> rekeningen = new ArrayList<>();

	public void voegRekeningToe(Rekening rekening) {
		if (rekening != null)
			rekeningen.add(rekening);
	}
	
	public List<Rekening> getRekeningen() {
		return rekeningen;
	}

	private Rekening geefRekening(int indexVanRekening) {
		if (indexVanRekening < 0 || indexVanRekening >= rekeningen.size())
			return null;
		return rekeningen.get(indexVanRekening);
	}

	public void stort(int indexVanRekening, BigDecimal bedrag) {
		Rekening rekening = geefRekening(indexVanRekening);
		if (rekening != null)
			rekening.stort(bedrag);
	}

	public void haalAf(int indexVanRekening, BigDecimal bedrag) {
		Rekening rekening = geefRekening(indexVanRekening);
		if (rekening != null)
			rekening.haalAf(bedrag);
	}

	public void schrijfOver(int indexVanRekening, int indexNaarRekening, BigDecimal bedrag) {
		Rekening rekeningVan = geefRekening(indexVanRekening);
		Rekening rekeningNaar = geefRekening(indexNaarRekening);
		if (rekeningVan != null && rekeningNaar != null)
			rekeningVan.schrijfOver(bedrag, rekeningNaar);	
	}

}