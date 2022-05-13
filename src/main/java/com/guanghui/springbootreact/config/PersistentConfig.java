package com.guanghui.springbootreact.config;

import org.springframework.context.annotation.Configuration;

// not required in this app, but just to demo that Config is important
// this will override the application.yml!
@Configuration
public class PersistentConfig {
//    @Bean
//    public DataSource getDatasource() {
//        DataSourceBuilder builder = DataSourceBuilder.create();
//        builder.url("jdbc:postgresql://localhost:5433/conference?user=postgres&password=ca$hc0w");
//        System.out.println("Our connection string will be overwritten with this.");
//        return builder.build();
//    }
}
