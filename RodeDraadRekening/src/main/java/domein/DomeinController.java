package domein;

import java.math.BigDecimal;
import java.util.List;

import dto.RekeningDTO;

public class DomeinController {
	private Bank miniBank = new Bank();

	public void voegRekeningToe(long rekeningNummer, String houder) {
		Rekening rekening = new Rekening(rekeningNummer, houder);
		miniBank.voegRekeningToe(rekening);
	}

	public void voegRekeningToe(long rekeningNummer, String houder, BigDecimal saldo) {
		Rekening rekening = new Rekening(rekeningNummer, houder, saldo);
		miniBank.voegRekeningToe(rekening);
	}

	public RekeningDTO[] geefRekeningen() {
		List<Rekening> alleRekeningen = miniBank.getRekeningen();
		RekeningDTO[] resultaat = new RekeningDTO[alleRekeningen.size()];
		int index = 0;
		for (Rekening r : alleRekeningen)
			resultaat[index++] = new RekeningDTO(r.getRekeningnummer(), r.getHouder(), r.getSaldo());
		return resultaat;
	}

	public void stort(int indexVanRekening, BigDecimal bedrag) {
		miniBank.stort(indexVanRekening, bedrag); 
	}

	public void haalAf(int indexVanRekening, BigDecimal bedrag) {
		miniBank.haalAf(indexVanRekening, bedrag);
	}

	public void schrijfOver(int indexVanRekening, int indexNaarRekening, BigDecimal bedrag) {
		miniBank.schrijfOver(indexVanRekening, indexNaarRekening, bedrag);
	}

}
