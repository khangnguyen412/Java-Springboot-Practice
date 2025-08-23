package com.example.JavaSpingBootPractice.security;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.JavaSpingBootPractice.security.jwt.JwtFilter;

@Configuration
public class SecurityConfig {
    private final JwtFilter jwt_filter;

    public SecurityConfig(JwtFilter jwt_filter) {
        this.jwt_filter = jwt_filter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth -> config_auth(auth))
                .addFilterBefore(jwt_filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    /**
     * Nếu ko dùng JwtFilter, thì ko cần addFilterBefore
     * @param http
     * @return
     * @throws Exception
     */
    /*@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth -> config_auth(auth)).httpBasic();
        return http.build();
    }*/

    private void config_auth(AuthorizeHttpRequestsConfigurer<?>.AuthorizationManagerRequestMatcherRegistry auth) {
        auth.requestMatchers(SecurityConstants.PUBLIC_ENDPOINTS).permitAll()
                .requestMatchers(SecurityConstants.USER_ENDPOINTS).hasRole("USER")
                .requestMatchers(SecurityConstants.ADMIN_ENDPOINTS).hasRole("ADMIN")
                .anyRequest().authenticated();
    }
}

class SecurityConstants {
    public static final String[] PUBLIC_ENDPOINTS = {
            "/lecture1/**",
            "/lecture2/**",
            "/lecture3/**",
            "/lecture4/login",
            "/lecture4/api/public",
            "/lecture5/**",
            "/lecture6/**",
            "/actuator/**"
    };

    public static final String[] USER_ENDPOINTS = {
            "/lecture4/api/user"
    };

    public static final String[] ADMIN_ENDPOINTS = {
            "/lecture4/api/admin"
    };
}