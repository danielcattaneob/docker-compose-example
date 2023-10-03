package ar.edu.utn.frc.tup.lciv.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String currency;

    private BigDecimal value;
}
