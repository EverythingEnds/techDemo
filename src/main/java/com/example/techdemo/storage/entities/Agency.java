package com.example.techdemo.storage.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name="agency")
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String fullname;
    @Column(columnDefinition = "TEXT")
    private String shortname;
    private String INN;
    private String OGRN;
    @OneToOne(targetEntity = Address.class)
    private Address postalAddress;
    @OneToOne(targetEntity = Address.class)
    private Address legalAddress;
    @OneToOne(targetEntity = Employee.class)
    private Employee director;
    @OneToMany(targetEntity = Branch.class, mappedBy = "agency")
    private List<Branch> branches;
}
