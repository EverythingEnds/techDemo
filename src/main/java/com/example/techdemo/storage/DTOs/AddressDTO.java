package com.example.techdemo.storage.DTOs;

import lombok.Data;

@Data
public class AddressDTO {
    private Long id;
    private Long index;
    private String region;
    private String city;
    private String street;
    private String house;
    private Integer apartments;
}
