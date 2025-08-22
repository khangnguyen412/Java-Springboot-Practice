package com.example.JavaSpingBootPractice.security.jwt;

import java.util.*;
import java.security.*;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.*;
import org.springframework.stereotype.*;

@Component
public class JwtTokenProvider {
    // Sinh token
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generate_token(String username, String role) {
        Date expiration = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10);
        Date date = new Date();
        return Jwts.builder().setSubject(username).claim("role", role).setIssuedAt(date).setExpiration(expiration)
                .signWith(key).compact();
    }

    // Lấy username từ token
    public String extract_username(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
    }
    
    // Lấy username từ token
    public String extract_role(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().get("role", String.class);
    }

    // Kiểm tra token
    public boolean validate_token(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            return false;
        } catch (UnsupportedJwtException e) {
            return false;
        } catch (MalformedJwtException e) {
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}