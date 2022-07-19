package com.example.techdemo.storage.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
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
@Data
@Indexed
@Entity(name = "branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    @FullTextField()
    private String name;
    @OneToOne(targetEntity = Address.class)
    @IndexedEmbedded
    @IndexingDependency(reindexOnUpdate = ReindexOnUpdate.SHALLOW)
    private Address postalAddress;
    @OneToOne(targetEntity = Employee.class)
    @IndexedEmbedded
    @IndexingDependency(reindexOnUpdate = ReindexOnUpdate.SHALLOW)
    private Employee chief;
    @ManyToOne
    @IndexingDependency(reindexOnUpdate = ReindexOnUpdate.SHALLOW)
    private Agency agency;
}
