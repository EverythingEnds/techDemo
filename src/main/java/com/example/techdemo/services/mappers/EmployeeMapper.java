package com.example.techdemo.services.mappers;

import com.example.techdemo.storage.DTOs.AgencyDTO;
import com.example.techdemo.storage.DTOs.EmployeeDTO;
import com.example.techdemo.storage.entities.Agency;
import com.example.techdemo.storage.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * MapStruct mapper for Employee entity/DTO
 *
 * @author Viktorov Daniil
 * @version 1.0
 * @since 2022-07-19
 */
@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeMapper employeeMapper = Mappers.getMapper(EmployeeMapper.class);
    Employee dtoToEntity(EmployeeDTO dto);
    EmployeeDTO entityToDto(Employee entity);
}
