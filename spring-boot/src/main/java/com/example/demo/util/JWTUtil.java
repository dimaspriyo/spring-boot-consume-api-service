package com.example.demo.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {

    public static String generateToken(String username) {
        Map<String,Object> map = new HashMap<>() {
            {
                put("username", "username");
            }
        };
        return Jwts.builder().setClaims(map).setExpiration(new Date(System.currentTimeMillis() + 3600))
                .signWith(SignatureAlgorithm.HS512, "s3cretk3y").compact();
    }
}
