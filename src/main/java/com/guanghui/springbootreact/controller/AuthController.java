package com.guanghui.springbootreact.controller;

import com.guanghui.springbootreact.model.AccountCredentials;
import com.guanghui.springbootreact.service.JwtServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;  // config it at SecurityConfig

    @Autowired
    private JwtServiceImpl jwtService;

    @PostMapping("/api/v1/login")
    public ResponseEntity<?> getToken(@RequestBody AccountCredentials credentials) {

        UsernamePasswordAuthenticationToken creds = new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword());

        Authentication auth = authenticationManager.authenticate(creds);

        // generate token
        String jwt = jwtService.generateToken(auth.getName());

        // build response with generated token
        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + jwt)
                .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Authorization")
                .build();
    }
}
