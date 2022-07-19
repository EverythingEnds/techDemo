package com.example.techdemo.storage.entities;

import lombok.*;
import org.hibernate.search.engine.backend.types.ObjectStructure;
import org.hibernate.search.mapper.pojo.automaticindexing.ReindexOnUpdate;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexingDependency;

import javax.persistence.*;

/**
 * Branch entity, keeps info about branch that related to branch.
 * Has relations to other entities like Address, Employee, Branch
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
@Entity(name = "branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    @FullTextField
    private String name;
    @OneToOne(targetEntity = Address.class)
    @IndexedEmbedded
    private Address postalAddress;
    @OneToOne(targetEntity = Employee.class)
    @IndexedEmbedded(structure = ObjectStructure.NESTED)
    private Employee chief;
    @ManyToOne
    private Agency agency;
}
