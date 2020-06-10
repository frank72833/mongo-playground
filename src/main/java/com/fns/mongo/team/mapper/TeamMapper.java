package com.fns.mongo.team.mapper;

import com.fns.mongo.support.SpringMapperConfig;
import com.fns.mongo.team.Team;
import com.fns.mongo.team.rest.v1.request.TeamRequest;
import org.mapstruct.Mapper;

@Mapper(config = SpringMapperConfig.class)
public interface TeamMapper {
    Team teamRequestToTeam(TeamRequest request);
}
