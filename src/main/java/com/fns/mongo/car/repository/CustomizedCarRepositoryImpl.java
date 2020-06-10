package com.fns.mongo.car.repository;

import com.fns.mongo.car.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Component
public class CustomizedCarRepositoryImpl implements CustomizedCarRepository {

    private final MongoOperations operations;

    @Autowired
    public CustomizedCarRepositoryImpl(MongoOperations operations) {
        this.operations = operations;
    }

    public List<Car> getAllCarsHigherThanHp(int hp) {
        return operations.query(Car.class)
                .matching(Query.query(where("engine.hp").gte(hp)))
                .all();
    }
}
