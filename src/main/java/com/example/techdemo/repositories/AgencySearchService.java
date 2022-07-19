package com.example.techdemo.repositories;

import com.example.techdemo.storage.entities.Agency;
import liquibase.repackaged.net.sf.jsqlparser.expression.operators.relational.FullTextSearch;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Agency search service to implement full text finding
 *
 * @author Viktorov Daniil
 * @version 1.0
 * @since 2022-07-19
 */
@Service
public class AgencySearchService {
//    @PersistenceContext
    @Autowired
    private EntityManager entityManager;
//    @Autowired
//    EntityManagerFactory factory;

    /**
     * Full text searching for agency entity
     *
     * @param text  value for finding in
     * @param field fields where to find
     * @return matched entities
     */
    public List<Agency> searchBy(String text, String... field) {
//       EntityManager entityManager = factory.createEntityManager();
        SearchSession searchSession =
                Search.session(entityManager);

        SearchResult<Agency> result = searchSession.search(Agency.class)
//                .where(x -> x.match()
//                        .fields(field)
//                        .matching(text))
                .where(x->x.matchAll()) //also doesnt work, so there is trouble with session;
                .fetchAll();

        List<Agency> hits = result.hits();
        return hits;
    }
}
