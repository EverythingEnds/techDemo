package com.example.techdemo.services;


import com.example.techdemo.services.mappers.AgencyMapper;
import com.example.techdemo.storage.DTOs.AgencyDTO;
import com.example.techdemo.storage.entities.Agency;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Conversion service that implements conversion from entity to DTO case,
 * also uses mappers that was auto created by MapStruct
 *
 * @author Viktorov Daniil
 * @version 1.0
 * @since 2022-07-19
 */
@Service
public class ConversionService {

    private final AgencyMapper agencyMapper;

    public ConversionService(AgencyMapper agencyMapper) {
        this.agencyMapper = agencyMapper;
    }

    /**
     * converting list pf agency entities to agency DTOs
     *
     * @param agencies entities to convert
     * @return converted DTOs
     */
    public List<AgencyDTO> convertAgencies(List<Agency> agencies) {
        return agencies.stream().map(agencyMapper::entityToDto).collect(Collectors.toList());
    }

    /**
     * converting single agency entity to agency DTO
     *
     * @param agency entity to convert
     * @return converted DTO
     */
    public AgencyDTO convertAgency(Agency agency) {
        return agencyMapper.entityToDto(agency);
    }
}
