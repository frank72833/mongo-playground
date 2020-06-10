package com.fns.mongo.car.rest.v1;

import com.fns.mongo.car.Car;
import com.fns.mongo.car.mapper.CarMapper;
import com.fns.mongo.car.repository.CarRepository;
import com.fns.mongo.car.serviceprovider.CarServiceProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/cars", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarsResource {

    private final CarServiceProvider carServiceProvider;
    private final CarRepository carRepository;

    @Autowired
    public CarsResource(CarServiceProvider carServiceProvider, CarMapper carMapper, CarRepository carRepository) {
        this.carServiceProvider = carServiceProvider;
        this.carRepository = carRepository;
    }

    @GetMapping("/{license}")
    public Car getCar(@PathVariable("license") String license) {
        return carServiceProvider.getCar(license)
                .orElseThrow(() -> { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car Not Found"); });
    }

    @GetMapping
    public List<Car> getCarByHp(@RequestParam(defaultValue = "0") int hp) {
        return carRepository.getAllCarsHigherThanHp(hp);
    }
}
