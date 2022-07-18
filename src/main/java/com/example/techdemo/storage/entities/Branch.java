package com.example.techdemo.storage.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity(name="branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;
    @OneToOne(targetEntity = Address.class)
    private Address postalAddress;
    @OneToOne(targetEntity = Employee.class)
    private Employee chief;
    @ManyToOne
    private Agency agency;
}
