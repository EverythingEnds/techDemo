package com.example.techdemo;

import com.example.techdemo.configs.IndexConfig;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * "TechDemoApp" application that keeps working with agency information.
 * Implemented logic related to Spring Boot, Hibernate.
 * Currently working with Postgresql DB, liquibase,
 *
 * @author Viktorov Daniil
 * @version 1.0
 * @since 2022-07-19
 */
@SpringBootApplication
@EnableTransactionManagement
public class TechDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechDemoApplication.class, args);
    }

    @Bean
    public ApplicationRunner buildIndex(IndexConfig indexer) {
        return (ApplicationArguments args) -> {
            indexer.indexPersistedData();
        };
    }
}
