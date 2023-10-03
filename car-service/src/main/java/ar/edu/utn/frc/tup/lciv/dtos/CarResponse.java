package ar.edu.utn.frc.tup.lciv.dtos;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CarResponse {

    private String model;

    private BigDecimal internationalPrice;
    private BigDecimal localizedPrice;
}
