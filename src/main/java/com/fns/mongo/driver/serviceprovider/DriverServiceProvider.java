package com.fns.mongo.driver.serviceprovider;

import com.fns.mongo.car.Car;
import com.fns.mongo.driver.Driver;
import com.fns.mongo.driver.mapper.DriverMapper;
import com.fns.mongo.driver.repository.DriverRepository;
import com.fns.mongo.driver.rest.v1.request.DriverRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class DriverServiceProvider {

    private final DriverRepository driverRepository;
    private final DriverMapper driverMapper;

    @Autowired
    public DriverServiceProvider(DriverRepository driverRepository, DriverMapper driverMapper) {
        this.driverRepository = driverRepository;
        this.driverMapper = driverMapper;
    }

    public Driver createDriver(Driver driver) {
        log.info("addDriver: {}", driver);

        driver.setId(UUID.randomUUID().toString());
        return driverRepository.insert(driver);
    }

    public Driver addDriver(String teamId, DriverRequest request) {
        log.info("addDriver: teamId: {}, {}",teamId, request);

        Driver driver = driverMapper.driverRequestToDriver(request);
        driver.setTeamId(teamId);

        return createDriver(driver);
    }

    public Optional<Driver> getDriver(String id) {
        return driverRepository.findById(id);
    }

    public List<Driver> findByTeamId(String teamId) {
        return driverRepository.findByTeamId(teamId);
    }
}
