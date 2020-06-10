package com.fns.mongo.car.mapper;

import com.fns.mongo.car.Car;
import com.fns.mongo.support.SpringMapperConfig;
import org.mapstruct.Mapper;
import com.fns.mongo.car.rest.v1.request.CarRequest;

@Mapper(config = SpringMapperConfig.class)
public interface CarMapper {
    Car carRequestToCar(CarRequest req);
}
