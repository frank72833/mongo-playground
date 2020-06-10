package com.fns.mongo.support;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.MapperConfig;

@MapperConfig(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SpringMapperConfig {}
