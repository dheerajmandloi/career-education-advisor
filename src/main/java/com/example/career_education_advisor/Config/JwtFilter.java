package com.example.career_education_advisor.Config;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.career_education_advisor.Models.User;
import com.example.career_education_advisor.Repositories.UserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private Jwtutils jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain)
            throws ServletException, IOException {

        String path = request.getServletPath();

        System.out.println("===== JWT DEBUG =====");
        System.out.println("PATH: " + path);

        // Non-API requests ko JWT filter se skip karo
        if (!path.startsWith("/api")) {
            chain.doFilter(request, response);
            return;
        }

        // Login/Register public APIs
        if (path.startsWith("/api/auth")) {
            chain.doFilter(request, response);
            return;
        }

        // Recommendation APIs public hain
        // Inhe JWT authentication ki zarurat nahi hai
        if (path.startsWith("/api/recommendation")) {
            System.out.println("RECOMMENDATION API - JWT FILTER SKIPPED");

            chain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader("Authorization");

        System.out.println(
                "AUTH HEADER PRESENT: "
                        + (authHeader != null));

        if (authHeader != null
                && authHeader.startsWith("Bearer ")) {

            String token = authHeader.substring(7);

            try {

                String email = jwtUtil.extractUserName(token);

                System.out.println(
                        "EMAIL FROM TOKEN: " + email);

                if (email != null
                        && SecurityContextHolder
                                .getContext()
                                .getAuthentication() == null) {

                    User user = userRepository
                            .findByEmail(email)
                            .orElse(null);

                    if (user != null) {

                        System.out.println(
                                "USER FOUND: "
                                        + user.getEmail());

                        System.out.println(
                                "USER ROLE: "
                                        + user.getRole());

                        if (jwtUtil.validateToken(token)) {

                            String role = user.getRole().name();

                            List<SimpleGrantedAuthority> authorities = List.of(
                                    new SimpleGrantedAuthority(
                                            "ROLE_" + role));

                            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                                    user,
                                    null,
                                    authorities);

                            SecurityContextHolder
                                    .getContext()
                                    .setAuthentication(
                                            authentication);

                            System.out.println(
                                    "AUTH SET: "
                                            + SecurityContextHolder
                                                    .getContext()
                                                    .getAuthentication());

                        } else {

                            System.out.println(
                                    "TOKEN INVALID OR EXPIRED");
                        }

                    } else {

                        System.out.println(
                                "USER NOT FOUND: "
                                        + email);
                    }
                }

            } catch (Exception e) {

                System.out.println(
                        "JWT ERROR: "
                                + e.getMessage());

                e.printStackTrace();
            }
        }

        System.out.println(
                "FINAL AUTH: "
                        + SecurityContextHolder
                                .getContext()
                                .getAuthentication());

        chain.doFilter(request, response);
    }
}