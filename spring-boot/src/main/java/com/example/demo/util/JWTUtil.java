package com.example.demo.util;

import com.example.demo.repository.AccountRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTUtil {


    @Autowired
    private AccountRepository accountRepository;

    private String signingKey = "s3cretk3y";

    public String generateToken(String username) {
        Map<String, Object> map = new HashMap<>() {
            {
                put("username", username);
            }
        };
        return Jwts.builder().setClaims(map).setExpiration(new Date(System.currentTimeMillis() + 360000))
                .signWith(SignatureAlgorithm.HS512, this.signingKey).compact();
    }

    public Boolean isExpired(Claims claims) {
        return claims.getExpiration().after(new Date());
    }

    private Claims getAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(signingKey)
                .parseClaimsJws(token)
                .getBody();
    }

    public Boolean validate(String token) {
        Claims claims = getAllClaims(token);

        if (!isExpired(claims)) {
            if (accountRepository.findByUsername(claims.get("username").toString()).isEmpty()) {
                throw new JwtException("Token Invalid");
            }
            throw new JwtException("JWT Token Expired");
        }
        return true;
    }
}
