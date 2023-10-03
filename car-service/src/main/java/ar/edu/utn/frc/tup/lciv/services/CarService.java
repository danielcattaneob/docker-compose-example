package ar.edu.utn.frc.tup.lciv.services;

import ar.edu.utn.frc.tup.lciv.clients.ExchangeRateClient;
import ar.edu.utn.frc.tup.lciv.clients.ExchangeRateResponse;
import ar.edu.utn.frc.tup.lciv.dtos.CarResponse;
import ar.edu.utn.frc.tup.lciv.entities.Car;
import ar.edu.utn.frc.tup.lciv.repositories.CarRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final ExchangeRateClient exchangeRateClient;

    private static final String LOCALIZED_CURRENCY = "ARS";

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public CarResponse getLocalizedCar(Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);

        if (optionalCar.isEmpty()) throw new EntityNotFoundException();

        Car car = optionalCar.get();

        return CarResponse.builder()
                .model(car.getModel())
                .internationalPrice(car.getInternationalPrice())
                .localizedPrice(calculateLocalizedPrice(getCurrencyRate(LOCALIZED_CURRENCY), car.getInternationalPrice()))
                .build();
    }

    private BigDecimal getCurrencyRate(String currency) {
        ExchangeRateResponse exchangeRate = exchangeRateClient.getExchangeRateByCurrency(currency);
        return exchangeRate.getValue();
    }

    private BigDecimal calculateLocalizedPrice(BigDecimal currencyRate, BigDecimal internationalPrice) {
        return currencyRate.multiply(internationalPrice);
    }

}

