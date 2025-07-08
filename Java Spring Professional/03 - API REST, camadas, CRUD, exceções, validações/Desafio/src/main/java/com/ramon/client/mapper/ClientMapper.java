package com.ramon.client.mapper;

import com.ramon.client.dto.ClientDTO;
import com.ramon.client.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClientMapper extends BaseMapper<ClientDTO, Client> {

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(ClientDTO dto, @MappingTarget Client entity);
}
