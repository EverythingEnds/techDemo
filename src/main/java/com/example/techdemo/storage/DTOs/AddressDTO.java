package com.example.techdemo.storage.DTOs;

import lombok.Data;

/**
 * DTO for address entity
 *
 * @author Viktorov Daniil
 * @version 1.0
 * @since 2022-07-19
 */
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
