package com.fns.mongo.car.rest.v1;

import com.fns.mongo.car.Car;
import com.fns.mongo.car.mapper.CarMapper;
import com.fns.mongo.car.serviceprovider.CarServiceProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/cars", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarsResource {

    private final CarServiceProvider carServiceProvider;

    @Autowired
    public CarsResource(CarServiceProvider carServiceProvider, CarMapper carMapper) {
        this.carServiceProvider = carServiceProvider;
    }

    @GetMapping("/{license}")
    public Car getCar(@PathVariable("license") String license) {
        return carServiceProvider.getCar(license)
                .orElseThrow(() -> { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car Not Found"); });
    }
}
