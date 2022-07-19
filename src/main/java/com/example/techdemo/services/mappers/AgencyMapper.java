package com.example.techdemo.services.mappers;

import com.example.techdemo.storage.DTOs.AgencyDTO;
import com.example.techdemo.storage.entities.Agency;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * MapStruct mapper for Agency entity/DTO
 *
 * @author Viktorov Daniil
 * @version 1.0
 * @since 2022-07-19
 */
@Mapper(componentModel = "spring")
public interface AgencyMapper {
    AgencyMapper agencyMapper = Mappers.getMapper(AgencyMapper.class);

    Agency dtoToEntity(AgencyDTO dto);

    AgencyDTO entityToDto(Agency entity);
}
