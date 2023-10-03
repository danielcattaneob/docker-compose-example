package ar.edu.utn.frc.tup.lciv.controllers;

import ar.edu.utn.frc.tup.lciv.dtos.ExchangeRateResponse;
import ar.edu.utn.frc.tup.lciv.entities.ExchangeRate;
import ar.edu.utn.frc.tup.lciv.services.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    @PostMapping("/exchange-rate")
    public ExchangeRate createExchangeRate(@RequestBody ExchangeRate exchangeRate) {
        return exchangeRateService.createExchangeRate(exchangeRate);
    }

    @GetMapping("/exchange-rate/{currency}")
    public ExchangeRateResponse getExchangeRateByCurrency(@PathVariable String currency) {
        return exchangeRateService.getExchangeRateByCurrency(currency);
    }
}
