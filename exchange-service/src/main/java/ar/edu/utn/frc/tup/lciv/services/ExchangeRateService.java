package ar.edu.utn.frc.tup.lciv.services;

import ar.edu.utn.frc.tup.lciv.dtos.ExchangeRateResponse;
import ar.edu.utn.frc.tup.lciv.entities.ExchangeRate;
import ar.edu.utn.frc.tup.lciv.repositories.ExchangeRateRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExchangeRateService {

    private final ExchangeRateRepository exchangeRateRepository;

    public ExchangeRate createExchangeRate(ExchangeRate exchangeRate) {
        return exchangeRateRepository.save(exchangeRate);
    }

    public ExchangeRateResponse getExchangeRateByCurrency(String currency) {
        Optional<ExchangeRate> optionalExchangeRate = exchangeRateRepository.findByCurrency(currency);

        if (optionalExchangeRate.isEmpty()) throw new EntityNotFoundException();

        ExchangeRate exchangeRate = optionalExchangeRate.get();

        return ExchangeRateResponse.builder()
                .currency(exchangeRate.getCurrency())
                .value(exchangeRate.getValue())
                .build();
    }
}
