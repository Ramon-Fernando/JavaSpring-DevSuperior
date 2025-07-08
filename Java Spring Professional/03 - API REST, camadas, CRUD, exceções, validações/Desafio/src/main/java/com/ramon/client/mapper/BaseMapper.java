package com.ramon.client.mapper;

import org.mapstruct.MappingTarget;

public interface BaseMapper<DTO, Entity> {
    DTO toDTO(Entity entity);
    Entity toEntity(DTO dto);

    void updateEntityFromDTO(DTO dto, @MappingTarget Entity entity);
}
