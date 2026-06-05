package org.example.mapper;

import org.example.entities.DBEntity;
import org.example.entities.MaryEntity;
import org.example.engine.MaryEntityRules;
import org.example.engine.RuleEngine;
import org.mapstruct.AfterMapping;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface DBEntityMapper {
    @Mapping(source = "ALong", target = "aLong")
    @Mapping(source = "structure", target = "structure2")
    MaryEntity toMaryEntity(DBEntity dbEntity);

    @AfterMapping
    default void applyMaryEntityRules(DBEntity source, @MappingTarget MaryEntity target) {
        RuleEngine.applyAll(MaryEntityRules.rules(target));
    }

    DBEntityMapper INSTANCE = Mappers.getMapper(DBEntityMapper.class);
}