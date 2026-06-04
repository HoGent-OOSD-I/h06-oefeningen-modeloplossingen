package domein;

import java.math.BigDecimal;

public class Rekening {

	private long rekeningnummer;
	private String houder;
	private BigDecimal saldo;

	private static final int MAX_CIJFERS = 12;

	public Rekening(long rekeningnummer, String houder) {
		this(rekeningnummer, houder, BigDecimal.ZERO);
	}

	public Rekening(long rekeningnummer, String houder, BigDecimal saldo) {
		setRekeningnummer(rekeningnummer);
		setHouder(houder);
		setSaldo(saldo);
	}

	private void setRekeningnummer(long rekeningnummer) {
		if (rekeningnummer > 999999999999L)
			throw new IllegalArgumentException(
					String.format("Rekeningnummer kan niet meer dan %d cijfers hebben", MAX_CIJFERS));
		this.rekeningnummer = rekeningnummer;
	}

	private void setHouder(String houder) {
		if (houder == null || houder.isBlank())
			throw new IllegalArgumentException("Ongeldige houder");
		this.houder = houder;
	}

	private void setSaldo(BigDecimal saldo) {
        if (saldo.signum() < 0)
            throw new IllegalArgumentException("Saldo kan niet negatief zijn!");
		this.saldo = saldo;
	}

	public long getRekeningnummer() {
		return rekeningnummer;
	}

	public String getHouder() {
		return houder;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

    private void controleBedrag(BigDecimal bedrag)
    {
        if (bedrag.signum() <= 0)
            throw new IllegalArgumentException("Bedrag kan niet nul of negatief zijn!");
    }

	public void stort(BigDecimal bedrag) {
		controleBedrag(bedrag);
        setSaldo(saldo.add(bedrag));
	}

	public void haalAf(BigDecimal bedrag) {
        controleBedrag(bedrag);
        setSaldo(saldo.subtract(bedrag));
	}

	public void schrijfOver(BigDecimal bedrag, Rekening naarRekening) {
		if (naarRekening != null) {
			haalAf(bedrag);
			naarRekening.stort(bedrag);
		}
	}

}
