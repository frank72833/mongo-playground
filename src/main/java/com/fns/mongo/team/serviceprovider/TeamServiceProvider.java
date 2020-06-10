package com.fns.mongo.team.serviceprovider;

import com.fns.mongo.team.Team;
import com.fns.mongo.team.mapper.TeamMapper;
import com.fns.mongo.team.repository.TeamRepository;
import com.fns.mongo.team.rest.v1.request.TeamRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class TeamServiceProvider {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @Autowired
    public TeamServiceProvider(TeamRepository teamRepository, TeamMapper teamMapper) {
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
    }

    public Optional<Team> getTeam(String teamId) {
        return teamRepository.findById(teamId);
    }

    public Team createTeam(TeamRequest request) {
        Team team = teamMapper.teamRequestToTeam(request);
        team.setId(UUID.randomUUID().toString());

        return teamRepository.insert(team);
    }
}
