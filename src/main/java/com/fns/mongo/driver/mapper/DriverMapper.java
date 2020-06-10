package com.fns.mongo.driver.mapper;

import com.fns.mongo.driver.Driver;
import com.fns.mongo.driver.rest.v1.request.DriverRequest;
import com.fns.mongo.support.SpringMapperConfig;
import org.mapstruct.Mapper;

@Mapper(config = SpringMapperConfig.class)
public interface DriverMapper {
    Driver driverRequestToDriver(DriverRequest req);
}
