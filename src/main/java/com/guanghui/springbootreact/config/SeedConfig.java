package com.guanghui.springbootreact.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SeedConfig {
    private static final Logger log = LoggerFactory.getLogger(SeedConfig.class);

//    @Bean
//    CommandLineRunner initDatabase(EmployeeRepository repository) {
//
//        return args -> {
//            log.info("Preloading " + repository.save(new Employee("Derek Wang", "King")));
//            log.info("Preloading " + repository.save(new Employee("Iris Yuan", "Queen")));
//        };
//    }
}

/*
1. Spring Boot will run ALL CommandLineRunner beans once the application context is loaded.
2. This runner will request a copy of the EmployeeRepository you just created.
3. Using it, it will create two entities and store them.
*/
