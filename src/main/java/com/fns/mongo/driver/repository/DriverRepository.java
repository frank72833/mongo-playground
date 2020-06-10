package com.fns.mongo.driver.repository;

import com.fns.mongo.driver.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DriverRepository extends MongoRepository<Driver, String> {
    List<Driver> findByTeamId(String teamId);
}
