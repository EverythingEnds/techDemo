package com.example.techdemo.storage.DTOs;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDTO {
    private Long id;
    private String surname;
    private String firstname;
    private String patronymic;
    private LocalDate birthday;
}
