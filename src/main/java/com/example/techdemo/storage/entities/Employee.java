package com.example.techdemo.storage.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Employee entity, keeps info about branch that related to employee.
 * Has relations to other entities like Address, Employee, Branch
 *
 * @author Viktorov Daniil
 * @version 1.0
 * @since 2022-07-19
 */
@Data
@Indexed
@Entity(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    @FullTextField()
    private String surname;
    @FullTextField()
    private String firstname;
    @FullTextField()
    private String patronymic;
    @GenericField
    private LocalDate birthday;
}
