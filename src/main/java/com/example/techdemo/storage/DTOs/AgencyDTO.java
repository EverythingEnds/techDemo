package com.example.techdemo.storage.DTOs;

import lombok.Data;

import java.util.List;

@Data
public class AgencyDTO {
    private Long id;
    private String fullname;
    private String shortname;
    private String INN;
    private String OGRN;
    private AddressDTO postalAddress;
    private AddressDTO legalAddress;
    private EmployeeDTO director;
    private List<BranchDTO> branches;
}
