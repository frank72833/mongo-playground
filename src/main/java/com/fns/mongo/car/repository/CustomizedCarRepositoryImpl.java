package com.fns.mongo.car.repository;

import com.fns.mongo.car.Car;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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

    // Save can be used because I have a unique identifier (license)
    // but I was just checking how to implement this.
    public void update(Car car) {
        // Create query
        Query query = Query.query(Criteria.where(Car.ID)
                .is(car.getLicense()));

        // Create document
        Document doc = new Document();
        operations.getConverter().write(car, doc);

        // Update from document
        Update update = Update.fromDocument(doc);

        // Exec update
        operations.updateFirst(query, update, Car.class);
    }

    public void save(Car car) {
        operations.save(car);
    }
}
