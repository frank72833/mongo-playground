package com.fns.mongo.car.repository;

import com.fns.mongo.car.Car;

import java.util.List;

public interface CustomizedCarRepository {
    List<Car> getAllCarsHigherThanHp(int hp);
    void update(Car car);
}
