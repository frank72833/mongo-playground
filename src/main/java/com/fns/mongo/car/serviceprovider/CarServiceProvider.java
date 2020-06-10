package com.fns.mongo.car.serviceprovider;

import com.fns.mongo.car.Car;
import com.fns.mongo.car.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class CarServiceProvider {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceProvider(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car createCar(Car car) {
        log.info("createCar: {}", car);
        return carRepository.insert(car);
    }

    public Optional<Car> getCar(String license) {
        log.info("getCar: license: {}", license);
        return carRepository.findById(license);
    }
}
