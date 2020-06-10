package com.fns.mongo.car.serviceprovider;

import com.fns.mongo.car.Car;
import com.fns.mongo.car.mapper.CarMapper;
import com.fns.mongo.car.repository.CarRepository;
import com.fns.mongo.car.rest.v1.request.CarRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class CarServiceProvider {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Autowired
    public CarServiceProvider(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    public Car createCar(Car car) {
        log.info("createCar: {}", car);

        return carRepository.insert(car);
    }

    public Optional<Car> getCar(String license) {
        log.info("getCar: license: {}", license);

        return carRepository.findById(license);
    }

    public Car addCar(String teamId, CarRequest request) {
        log.info("addCar: teamId:{}, {}", teamId, request);

        Car car = carMapper.carRequestToCar(request);
        car.setTeamId(teamId);

        return createCar(car);
    }

    public List<Car> findByTeamId(String teamId) {
        return carRepository.findByTeamId(teamId);
    }
}
