package com.example.techdemo.storage.entities;

import lombok.*;
import org.hibernate.search.engine.backend.types.ObjectStructure;
import org.hibernate.search.mapper.pojo.automaticindexing.ReindexOnUpdate;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexingDependency;

import javax.persistence.*;
import java.util.List;

/**
 * Agency entity, keeps info about single agency.
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
@Entity(name = "agency")
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    @Column(columnDefinition = "TEXT")
    @FullTextField
    private String fullname;
    @Column(columnDefinition = "TEXT")
    @FullTextField
    private String shortname;
    @FullTextField
    private String INN;
    @FullTextField
    private String OGRN;
    @OneToOne(targetEntity = Address.class)
    @IndexedEmbedded
    @IndexingDependency(reindexOnUpdate = ReindexOnUpdate.SHALLOW)
    private Address postalAddress;
    @OneToOne(targetEntity = Address.class)
    @IndexedEmbedded
    private Address legalAddress;
    @OneToOne(targetEntity = Employee.class)
    @IndexedEmbedded
    @IndexingDependency(reindexOnUpdate = ReindexOnUpdate.SHALLOW)
    private Employee director;
    @OneToMany(targetEntity = Branch.class, mappedBy = "agency")
    @IndexedEmbedded(structure = ObjectStructure.NESTED)
//    @IndexingDependency(reindexOnUpdate = ReindexOnUpdate.SHALLOW)
    private List<Branch> branches;
}
