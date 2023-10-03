package ar.edu.utn.frc.tup.lciv.controllers;

import ar.edu.utn.frc.tup.lciv.dtos.CarResponse;
import ar.edu.utn.frc.tup.lciv.entities.Car;
import ar.edu.utn.frc.tup.lciv.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;


    @PostMapping("/car")
    public Car createCar(@RequestBody Car car) {
        return carService.createCar(car);
    }

    @GetMapping("/car/{id}/localized")
    public CarResponse getLocalizedCar(@PathVariable Long id) {
        return carService.getLocalizedCar(id);
    }
}
