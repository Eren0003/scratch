package com.example.jwt.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtService {

    private String SECRET_KEY = "397924423F4528482B4D6251655468576D5A7134743777217A25432A46294A40";
    public String generateAccessToken(String userName){
        Map<String,Object> claims = new HashMap<>();
        return createAccessToken(claims,userName);
    }
    public String generateRefreshToken(String userName){
        Map<String,Object> claims = new HashMap<>();
        return createRefreshToken(claims,userName);
    }
    public String createAccessToken(Map<String, Object> claims, String userName) {
       return  Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*5*60))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }
    public String createRefreshToken(Map<String,Object> claims,String userName){
        return  Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*24))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }
    public Key getSignKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    public boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }
    public boolean isTokenValid(String token , UserDetails UserDetails){
        final String userName  = extractUserName(token);
        return (userName.equals(UserDetails.getUsername()) && !isTokenExpired(token));
    }
    public String extractUserName(String token){
        return extractClaims(token, Claims::getSubject);
    }
    public Date extractExpiration(String token){
        return extractClaims(token,Claims::getExpiration);
    }
    public <T>T extractClaims(String token, Function<Claims,T> claimsResolver ){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    public Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
