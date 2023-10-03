package ar.edu.utn.frc.tup.lciv.repositories;

import ar.edu.utn.frc.tup.lciv.entities.ExchangeRate;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ExchangeRateRepository extends CrudRepository<ExchangeRate, Long> {

    Optional<ExchangeRate> findByCurrency(String currency);
}
