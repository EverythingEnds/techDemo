package com.example.techdemo.storage.DTOs;

import lombok.Data;

/**
 * DTO for branch entity
 *
 * @author Viktorov Daniil
 * @version 1.0
 * @since 2022-07-19
 */
@Data
public class BranchDTO {
    private Long id;
    private String name;
    private AddressDTO postalAddress;
    private EmployeeDTO chief;
}
