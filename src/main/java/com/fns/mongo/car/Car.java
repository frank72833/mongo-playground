package com.fns.mongo.car;

import com.fns.mongo.engine.Engine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Car {
    public static final String ID = "license";

    @Id
    private String license;
    private String make;
    private String model;
    private Engine engine;

    private String teamId;
}
