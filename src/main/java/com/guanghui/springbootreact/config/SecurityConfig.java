package com.guanghui.springbootreact.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    //  Hash user typed raw password by algorithm, and then compare the result with db password.
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

//    @Override
//    // we can define which endpoints in our application are secure and which are not.
//    // We don't actually need this method yet because we can use the default settings where all the endpoints are secured
//    protected void configure(HttpSecurity http) throws Exception {
//    }

//    // For dev test purpose: add in-memory users
//    // With this, we already logged in via this user.
//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        // Not for production. only intended for sample applications
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
}
