package ar.edu.utn.frc.tup.lciv.dtos;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ExchangeRateResponse {

    private String currency;

    private BigDecimal value;
}
