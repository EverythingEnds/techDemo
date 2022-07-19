package com.example.techdemo.storage.entities;

import lombok.*;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.persistence.*;

/**
 * Address entity, keeps info about single address
 *
 * @author Viktorov Daniil
 * @version 1.0
 * @since 2022-07-19
 */
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Indexed
@Entity(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    @FullTextField
    private String index;
    @FullTextField
    private String region;
    @FullTextField
    private String city;
    @FullTextField
    private String street;
    @FullTextField
    private String house;
    @FullTextField
    private String apartments;
    @OneToOne(mappedBy = "legalAddress")
    private Agency agencyLegal;
    @OneToOne(mappedBy = "postalAddress")
    private Agency agencyPostal;
    @OneToOne(mappedBy = "postalAddress")
    private Branch branch;
}
