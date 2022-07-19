package com.example.techdemo.repositories;

import com.example.techdemo.storage.entities.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Agency repository to implement agency data related operations with DB
 *
 * @author Viktorov Daniil
 * @version 1.0
 * @since 2022-07-19
 */
@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long> {
}
