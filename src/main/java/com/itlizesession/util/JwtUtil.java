package com.itlizesession.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {
    private final String SECRET_KEY = "secret";

    public String extractUsername(String token) {
        return extractClainm(token, Claims::getSubject);
    }

    private <T> T extractClainm(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    //parse a JWT, verify its signature using a secret key, and extract the claims contained within it
    private Claims extractAllClaims(String token) {
        //returns a JwtParser instance
        //sets the signing key that will be used to verify the signature of the JWT
        //The parseClaimsJws(token) method takes a JWT as a string and attempts to parse it. If the JWT is successfully parsed, the method returns a Jws (JSON Web Signature) object that represents the JWT
        //extracts the claims from the Jws object and returns them as a JwsClaimsSet object
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    //get expiration date of token
    public Date extractExpiration(String token) {
        return extractClainm(token, Claims::getExpiration);
    }

    //check if token is expired
    public Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }


}
