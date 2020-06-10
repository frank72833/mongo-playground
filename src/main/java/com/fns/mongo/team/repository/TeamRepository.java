package com.fns.mongo.team.repository;

import com.fns.mongo.team.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepository extends MongoRepository<Team, String> {}
