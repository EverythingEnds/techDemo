package com.example.techdemo.repositories;

import com.example.techdemo.storage.entities.Agency;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Agency search service to implement full text finding
 *
 * @author Viktorov Daniil
 * @version 1.0
 * @since 2022-07-19
 */
@Service
public class AgencySearchService {

    private static final String agencyProperties = "[\"branches.postalAddress.street\",\"postalAddress.house\",\"branches.postalAddress.index\",\"director.firstname\",\"legalAddress.house\",\"INN\",\"branches.postalAddress.region\",\"branches.name\",\"legalAddress.apartments\",\"legalAddress.region\",\"postalAddress.region\",\"branches.postalAddress.house\",\"director.patronymic\",\"postalAddress.city\",\"legalAddress.city\",\"branches.chief.patronymic\",\"postalAddress.index\",\"branches.postalAddress.apartments\",\"legalAddress.index\",\"branches.postalAddress.city\",\"shortname\",\"director.surname\",\"OGRN\",\"branches.chief.firstname\",\"branches.chief.surname\",\"postalAddress.street\",\"fullname\",\"legalAddress.street\",\"postalAddress.apartments\"]";
    @Autowired
    private EntityManager entityManager;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private List<String> properties;


    @PostConstruct
    public void init() {
        try {
            properties = objectMapper.readValue(agencyProperties, ArrayList.class);
        } catch (JsonProcessingException e) {
            properties = new ArrayList<>();
        }
    }


    /**
     * Full text searching for agency entity
     *
     * @param text value for finding in
     * @return matched entities
     */
    public List<Agency> searchBy(String text) {
        SearchSession searchSession =
                Search.session(entityManager);
        SearchResult<Agency> result = searchSession.search(Agency.class).where
                (
                        x -> x.match()
                                .fields(properties.toArray(new String[0]))
                                .matching(text)
                ).fetchAll();
        List<Agency> hits = result.hits();
        return hits;
    }
}
