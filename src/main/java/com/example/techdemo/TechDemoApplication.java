package com.example.techdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
public class TechDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechDemoApplication.class, args);
    }

}
