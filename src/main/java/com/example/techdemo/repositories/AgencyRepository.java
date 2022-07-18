package com.example.techdemo.repositories;

import com.example.techdemo.storage.entities.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AgencyRepository extends JpaRepository<Agency, Long> {
//
//    @Query(
//            value = "from agency a WHERE " +
//                    "UPPER(a.fullname) LIKE UPPER(?1) " +
//                    "OR UPPER(a.shortname) LIKE UPPER(?1) " +
//                    "OR UPPER(a.INN) LIKE UPPER(?1) " +
//                    "OR UPPER(a.OGRN) LIKE UPPER(?1) " +
//                    "OR UPPER(a.legalAddress.city) LIKE UPPER(?1) " +
//                    "OR UPPER(a.legalAddress.house) LIKE UPPER(?1) " +
//                    "OR UPPER(a.legalAddress.region) LIKE UPPER(?1) " +
//                    "OR UPPER(a.legalAddress.street) LIKE UPPER(?1) " +
//                    "OR UPPER(a.postalAddress.city) LIKE UPPER(?1) " +
//                    "OR UPPER(a.postalAddress.house) LIKE UPPER(?1) " +
//                    "OR UPPER(a.postalAddress.region) LIKE UPPER(?1) " +
//                    "OR UPPER(a.postalAddress.street) LIKE UPPER(?1) " +
//    )
//    List<Agency> findAllByFilterValue(String filterValue);
}
