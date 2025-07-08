package com.ramon.client.mapper;

public interface BaseMapper<DTO, Entity> {
    DTO toDTO(Entity entity);
    Entity toEntity(DTO dto);
}
