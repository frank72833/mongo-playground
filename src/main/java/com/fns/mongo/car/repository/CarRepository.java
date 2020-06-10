package com.fns.mongo.car.repository;

import com.fns.mongo.car.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {
    List<Car> findByTeamId(String teamId);
}
