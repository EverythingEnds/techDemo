package com.example.techdemo.services.mappers;

import com.example.techdemo.storage.DTOs.AddressDTO;
import com.example.techdemo.storage.entities.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * MapStruct mapper for Address entity/DTO
 *
 * @author Viktorov Daniil
 * @version 1.0
 * @since 2022-07-19
 */
@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressMapper addressMapper = Mappers.getMapper(AddressMapper.class);

    Address dtoToEntity(AddressDTO dto);

    AddressDTO entityToDto(Address entity);
}
