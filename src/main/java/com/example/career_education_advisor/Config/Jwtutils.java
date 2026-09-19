package com.example.career_education_advisor.Config;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class Jwtutils {

    private final String SECRET = "76b4dcb47ca25b2a69e7c69430a885511021686a9baa25ee3ce71bdc1270faa7";

    private final long EXPIRATION = 1000 * 60 * 60; // 1 hour

    // Generate JWT Token
    public String generateToken(String email, String role) {

        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    // Extract Email
    public String extractUserName(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(SECRET)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Extract Role
    public String extractRole(String token) {

        return (String) Jwts.parserBuilder()
                .setSigningKey(SECRET)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("role");
    }

    // Check Token Expiry
    public boolean isTokenExpired(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(SECRET)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }

    // Validate Token
    public boolean validateToken(String token) {

        try {

            String username = extractUserName(token);

            return username != null && !isTokenExpired(token);

        } catch (Exception e) {

            return false;
        }
    }
}