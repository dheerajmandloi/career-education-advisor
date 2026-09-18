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

        // Public authentication APIs
        if (path.startsWith("/api/auth")) {
            chain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader("Authorization");

        String token = null;
        String email = null;

        // Extract JWT token
        if (authHeader != null && authHeader.startsWith("Bearer ")) {

            token = authHeader.substring(7);

            try {
                email = jwtUtil.extractUserName(token);
            } catch (Exception e) {
                chain.doFilter(request, response);
                return;
            }
        }

        // Validate user and token
        if (email != null &&
                SecurityContextHolder.getContext().getAuthentication() == null) {

            User user = userRepository.findByEmail(email)
                    .orElse(null);

            if (user != null && jwtUtil.validateToken(token)) {

                String role = user.getRole().name();

                List<SimpleGrantedAuthority> authorities = List.of(
                        new SimpleGrantedAuthority("ROLE_" + role));

                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        user,
                        null,
                        authorities);

                SecurityContextHolder
                        .getContext()
                        .setAuthentication(authToken);
            }
        }

        chain.doFilter(request, response);
    }
}