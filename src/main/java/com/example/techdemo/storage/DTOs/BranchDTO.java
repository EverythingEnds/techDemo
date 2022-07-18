package com.example.techdemo.storage.DTOs;

import lombok.Data;

@Data
public class BranchDTO {
    private Long id;
    private String name;
    private AddressDTO postalAddress;
    private EmployeeDTO chief;
}
