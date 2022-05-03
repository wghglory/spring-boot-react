package com.guanghui.springbootreact.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.Date;

@Service
public class JwtService {
    static final Integer EXPIRATION_TIME = 86400000; // 1 DAY in ms

    static final String PREFIX = "Bearer";

    // generate secret key. We should read it from Application configuration
    static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    /**
     * generate signed JWT token based on username
     *
     * @param username given username
     * @return token
     */
    public String generateToken(String username) {

        return Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    /**
     * verify a token and get username from request Authorization header
     *
     * @param request HttpRequest
     * @return username
     */
    public String validateTokenAndReturnUser(HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (token != null) {
            String user = Jwts.parserBuilder()
                    .setSigningKey(key).build()
                    // NOT.parseClaimsJwt()!!!
                    .parseClaimsJws(token.replace(PREFIX, ""))
                    .getBody()
                    .getSubject();

            return user;
        }

        return null;
    }
}
