package com.fns.mongo.team.rest.v1;

import com.fns.mongo.car.Car;
import com.fns.mongo.car.rest.v1.request.CarRequest;
import com.fns.mongo.car.serviceprovider.CarServiceProvider;
import com.fns.mongo.driver.Driver;
import com.fns.mongo.driver.rest.v1.request.DriverRequest;
import com.fns.mongo.driver.serviceprovider.DriverServiceProvider;
import com.fns.mongo.team.Team;
import com.fns.mongo.team.rest.v1.request.TeamRequest;
import com.fns.mongo.team.serviceprovider.TeamServiceProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/teams", produces = MediaType.APPLICATION_JSON_VALUE)
public class TeamsResource {

    private final TeamServiceProvider teamServiceProvider;
    private final CarServiceProvider carServiceProvider;
    private final DriverServiceProvider driverServiceProvider;

    @Autowired
    public TeamsResource(TeamServiceProvider teamServiceProvider, CarServiceProvider carServiceProvider, DriverServiceProvider driverServiceProvider) {
        this.teamServiceProvider = teamServiceProvider;
        this.carServiceProvider = carServiceProvider;
        this.driverServiceProvider = driverServiceProvider;
    }

    @PostMapping
    public Team createTeam(@RequestBody TeamRequest request) {
        return teamServiceProvider.createTeam(request);
    }
;
    @PostMapping("/{teamId}/car")
    public Car addCar(@PathVariable("teamId") String teamId, @RequestBody CarRequest request) {
        return carServiceProvider.addCar(teamId, request);
    }

    @PostMapping("/{teamId}/driver")
    public Driver addDriver(@PathVariable("teamId") String teamId, @RequestBody DriverRequest request) {
        return driverServiceProvider.addDriver(teamId, request);
    }

    @GetMapping("/{id}")
    public Team getTeam(@PathVariable("id") String id) {
        return teamServiceProvider.getTeam(id)
                .orElseThrow(() -> { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Team Not Found"); });
    }

    @GetMapping("/{teamId}/drivers")
    public List<Driver> getDrivers(@PathVariable("teamId") String teamId) {
        return driverServiceProvider.findByTeamId(teamId);
    }

    @GetMapping("/{teamId}/cars")
    public List<Car> getCars(@PathVariable("teamId") String teamId) {
        return carServiceProvider.findByTeamId(teamId);
    }
}
