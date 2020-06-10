package com.fns.mongo.driver.rest.v1;

import com.fns.mongo.driver.Driver;
import com.fns.mongo.driver.serviceprovider.DriverServiceProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/drivers", produces = MediaType.APPLICATION_JSON_VALUE)
public class DriversResource {

    private final DriverServiceProvider driverServiceProvider;

    @Autowired
    public DriversResource(DriverServiceProvider driverServiceProvider) {
        this.driverServiceProvider = driverServiceProvider;
    }

    @GetMapping("/{id}")
    public Driver getDriver(@PathVariable("id") String id) {
        return driverServiceProvider.getDriver(id)
                .orElseThrow(() -> { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Driver Not Found"); });
    }
}
