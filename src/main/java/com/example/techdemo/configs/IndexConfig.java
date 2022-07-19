package com.example.techdemo.configs;

import com.example.techdemo.storage.entities.Address;
import com.example.techdemo.storage.entities.Agency;
import com.example.techdemo.storage.entities.Branch;
import com.example.techdemo.storage.entities.Employee;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.massindexing.MassIndexer;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Configuration
public class IndexConfig {

    private static final int THREAD_NUMBER = 4;
    private static final List<Class<?>> entityClasses = List.of(Agency.class, Address.class, Branch.class, Employee.class);

    private final EntityManager entityManager;


    public IndexConfig(@Autowired EntityManager entityManager) throws InterruptedException {
        this.entityManager = entityManager;
    }

    @Transactional
    public void indexPersistedData() throws InterruptedException {
        SearchSession searchSession = Search.session(entityManager);
        MassIndexer massIndexer = searchSession.massIndexer(entityClasses).threadsToLoadObjects(THREAD_NUMBER);
        massIndexer.startAndWait();
    }
}