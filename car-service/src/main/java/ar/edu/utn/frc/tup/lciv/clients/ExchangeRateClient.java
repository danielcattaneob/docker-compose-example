package ar.edu.utn.frc.tup.lciv.clients;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ExchangeRateClient {

    private final RestTemplate restTemplate;

    @Value("${exchange-rate.base-url}")
    private String BASE_PATH;

    public ExchangeRateResponse getExchangeRateByCurrency(String currency) {
        return restTemplate.getForObject(BASE_PATH + currency, ExchangeRateResponse.class);
    }
}
