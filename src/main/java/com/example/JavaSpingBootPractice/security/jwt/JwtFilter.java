package com.example.JavaSpingBootPractice.security.jwt;

import java.util.*;
import java.io.*;
import org.slf4j.*;
import org.springframework.stereotype.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

@Component
public class JwtFilter implements Filter {
    private final Logger logger = LoggerFactory.getLogger(JwtFilter.class);

    private final JwtTokenProvider jwt_util;

    public JwtFilter(JwtTokenProvider jwt_util) {
        this.jwt_util = jwt_util;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest http_request = (HttpServletRequest) request;
        String token = http_request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            logger.info("Authorization header: {}", token);
            if (jwt_util.validate_token(token)) {
                String username = jwt_util.extract_username(token);
                String role = jwt_util.extract_role(token);
                List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_" + role.toUpperCase()));
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, null, authorities);
                SecurityContextHolder.getContext().setAuthentication(auth);
                logger.info("JwtFilter: user={}, role={}", username, role);
            } else {
                logger.warn("Invalid JWT token");
            }
        }
        chain.doFilter(request, response);
    }
}
