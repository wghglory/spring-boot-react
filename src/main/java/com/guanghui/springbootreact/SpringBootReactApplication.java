package com.guanghui.springbootreact;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootReactApplication {
    private static final Logger logger = LoggerFactory.getLogger(SpringBootReactApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(SpringBootReactApplication.class, args);
        logger.info("Application started");
    }

}
