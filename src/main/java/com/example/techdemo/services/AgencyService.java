package com.example.techdemo.services;

import com.example.techdemo.repositories.AgencyRepository;
import com.example.techdemo.storage.entities.Agency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AgencyService implements AgencyQuery {

    @Autowired
    private AgencyRepository agencyRepository;

    public Agency getSingleAgencyById(Long id) {
        Optional<Agency> agencyInfo = agencyRepository.findById(id);
        return agencyInfo.orElseThrow(() -> {
            throw new NoSuchElementException("Agency not found by id = " + id);
        });
    }

//    public List<Agency> getAgencyListByField(String filterValue){
//
//    }

}
