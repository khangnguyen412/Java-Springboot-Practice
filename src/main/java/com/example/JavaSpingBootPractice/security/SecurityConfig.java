package com.example.JavaSpingBootPractice.security;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.web.SecurityFilterChain;

@Configuration 
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth.requestMatchers("/lecture4/api/public").permitAll() // public
                        .requestMatchers("/lecture4/api/user").hasRole("USER") // chỉ user
                        .requestMatchers("/lecture4/api/admin").hasRole("ADMIN").anyRequest().authenticated()).httpBasic();
        return http.build();
    }
}
