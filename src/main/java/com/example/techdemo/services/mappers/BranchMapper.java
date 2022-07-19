package com.example.techdemo.services.mappers;

import com.example.techdemo.storage.DTOs.AgencyDTO;
import com.example.techdemo.storage.DTOs.BranchDTO;
import com.example.techdemo.storage.entities.Agency;
import com.example.techdemo.storage.entities.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * MapStruct mapper for Branch entity/DTO
 *
 * @author Viktorov Daniil
 * @version 1.0
 * @since 2022-07-19
 */
@Mapper(componentModel = "spring")
public interface BranchMapper {
    BranchMapper branchMapper = Mappers.getMapper(BranchMapper.class);
    Branch dtoToEntity(BranchDTO dto);
    BranchDTO entityToDto(Branch entity);
}
