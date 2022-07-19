package com.example.techdemo.storage.DTOs;

import lombok.Data;

import java.time.LocalDate;

/**
 * DTO for employee entity
 *
 * @author Viktorov Daniil
 * @version 1.0
 * @since 2022-07-19
 */
@Data
public class EmployeeDTO {
    private Long id;
    private String surname;
    private String firstname;
    private String patronymic;
    private LocalDate birthday;
}
