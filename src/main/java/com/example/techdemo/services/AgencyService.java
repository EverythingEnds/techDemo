package com.example.techdemo.services;

import com.example.techdemo.repositories.AgencyRepository;
import com.example.techdemo.repositories.AgencySearchService;
import com.example.techdemo.services.interfaces.AgencyQuery;
import com.example.techdemo.storage.DTOs.AgencyDTO;
import com.example.techdemo.storage.entities.Agency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


/**
 * Agency service that keeps business-logic related to Agency entity
 *
 * @author Viktorov Daniil
 * @version 1.0
 * @since 2022-07-19
 */
@Service
public class AgencyService implements AgencyQuery {

    @Autowired
    private AgencyRepository agencyRepository;

    @Autowired
    private AgencySearchService agencySearchService;

    @Autowired
    private ConversionService conversionService;

    /**
     * finding single entity by given id
     *
     * @param id identifier of such agency entity
     * @return found entity
     */
    @Override
    @Transactional(readOnly = true)
    public AgencyDTO getSingleAgencyById(long id) {
        Optional<Agency> agencyInfo = agencyRepository.findById(id);
        return conversionService.convertAgency(agencyInfo.orElseThrow
                (() -> {
                    throw new NoSuchElementException("Agency not found by id = " + id);
                }));
    }

    /**
     * finding entities by full text search if exists filter value,
     * other case return all agency entities
     *
     * @param filterValue value to full text search
     * @return found entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<AgencyDTO> getAgencyListByField(String filterValue) {
        List<Agency> agencies;
        if (filterValue == null || filterValue.isEmpty()) {
            agencies = agencyRepository.findAll();
        } else {
            //todo: field param hardcoded for debug, there is should be usage of predefined array
            agencies = agencySearchService.searchBy(filterValue, "fullname");
        }
        return conversionService.convertAgencies(agencies);
    }
}
