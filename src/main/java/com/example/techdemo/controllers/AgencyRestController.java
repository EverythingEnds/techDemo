package com.example.techdemo.controllers;

import com.example.techdemo.controllers.exceptions.RestApiException;
import com.example.techdemo.services.interfaces.AgencyQuery;
import com.example.techdemo.storage.DTOs.AgencyDTO;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Agency WEB API controller that provides methods to manipulate
 * data related to agencies
 *
 * @author Viktorov Daniil
 * @version 1.0
 * @since 2022-07-19
 */
@RestController
@OpenAPIDefinition(info = @Info(title = "Agencies API", description = "Getting information about agencies"))
@RequestMapping("/{version}/agency")
public class AgencyRestController {

    @Autowired
    private AgencyQuery agencyService;

    /**
     * Handles get all agencies request
     *
     * @param filterValue optional param that provides full text finding
     * @return response entity with list of agencies info objects,
     *         in error case contains error message with related response code
     */
    @GetMapping(path = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AgencyDTO>> getAgencies(@RequestParam Optional<String> filterValue) {
        final String endpoint = "/agency/get/all";
        try {
            return ResponseEntity.ok().body(agencyService.getAgencyListByField(filterValue.orElse(null)));
        } catch (IllegalArgumentException e) {
            throw getRestApiException(HttpStatus.BAD_REQUEST, endpoint, e.getMessage()).addParameter("filter_value", filterValue.orElse(null));
        } catch (NoSuchElementException e) {
            throw getRestApiException(HttpStatus.NOT_FOUND, endpoint, e.getMessage()).addParameter("filter_value", filterValue.orElse(null));
        } catch (AccessDeniedException e) {
            throw getRestApiException(HttpStatus.FORBIDDEN, endpoint, e.getMessage()).addParameter("filter_value", filterValue.orElse(null));
        }
    }

    /**
     * Handles get agency by id request
     *
     * @param id param to find such agency
     * @return response entity with list of agencies info objects,
     *         in error case contains error message with related response code
     */
    @GetMapping(path = "/get/byId", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AgencyDTO> getAgency(@RequestParam long id) {
        final String endpoint = "/agency/get/byId";
        try {
            AgencyDTO singleAgencyById = agencyService.getSingleAgencyById(id);
            return ResponseEntity.ok().body(singleAgencyById);
        } catch (IllegalArgumentException e) {
            throw getRestApiException(HttpStatus.BAD_REQUEST, endpoint, e.getMessage()).addParameter("id", id);
        } catch (NoSuchElementException e) {
            throw getRestApiException(HttpStatus.NOT_FOUND, endpoint, e.getMessage()).addParameter("id", id);
        } catch (AccessDeniedException e) {
            throw getRestApiException(HttpStatus.FORBIDDEN, endpoint, e.getMessage()).addParameter("id", id);
        }
    }

    /**
     * creating rest API exception with given data
     *
     * @param status http status that mapped by exception type
     * @param endpoint endpoint URL
     * @param message exception information
     * @return rest API exception with given data
     */
    private RestApiException getRestApiException(HttpStatus status, String endpoint, String message) {
        return new RestApiException(status).addParameter("method", endpoint).addParameter("message", message);
    }
}
