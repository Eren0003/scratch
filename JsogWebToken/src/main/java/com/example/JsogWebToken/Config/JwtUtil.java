package com.example.JsogWebToken.Config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

    private String SECRET_KEY = "";
    public String generateToken(UserDetails userDetails){
        Map<String ,Object> claims = new HashMap<>();
        return createToken(claims,userDetails.getUsername());
    }

    public String createToken(Map<String, Object> claims, String subject) {
    return Jwts.builder()
            .setClaims(claims)
            .setSubject(subject)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis()+(1000*60*60*10)))
            .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
            .compact();
    }
    public <T> T extractClaims(String token, Function<Claims,T>claimsResolver){
        final Claims claims = extractAll(token);
        return claimsResolver.apply(claims);
    }
    public String extractSubject(String token){
       return extractClaims(token,Claims::getSubject);
    }
    public Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }
    public boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }
    public Claims extractAll(String token) {
        return Jwts
                .parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
    public boolean validateToken(String token,UserDetails userDetails) {
        final String userName = extractSubject(token);
        return (userName.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }
}
