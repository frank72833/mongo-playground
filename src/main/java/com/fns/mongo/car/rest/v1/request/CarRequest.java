package com.fns.mongo.car.rest.v1.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CarRequest {
    private String license;
    private String make;
    private String model;
}
