package dto;

import java.math.BigDecimal;

public record RekeningDTO(long rekeningnummer, String houder, BigDecimal saldo)
{

}
