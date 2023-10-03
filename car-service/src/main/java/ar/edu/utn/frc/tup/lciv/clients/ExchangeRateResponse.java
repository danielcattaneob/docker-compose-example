package ar.edu.utn.frc.tup.lciv.clients;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ExchangeRateResponse {

    private String currency;

    private BigDecimal value;
}
