package com.example.techdemo.services.interfaces;

import com.example.techdemo.storage.DTOs.AgencyDTO;

import java.util.List;

/**
 * Interface that keeps methods related to get agent entities operations
 *
 * @author Viktorov Daniil
 * @version 1.0
 * @since 2022-07-19
 */
public interface AgencyQuery {
    /**
     * finding single entity by given id
     *
     * @param id identifier of such agency entity
     * @return found entity
     */
    AgencyDTO getSingleAgencyById(long id);

    /**
     * finding entities by full text search
     *
     * @param filterValue value to full text search
     * @return found entities
     */
    List<AgencyDTO> getAgencyListByField(String filterValue);
}
