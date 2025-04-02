package com.farmateste.farmateste.config;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.farmateste.farmateste.user.User;

@Service
public class TokenService {

        public String createToken(User user){
            try{
                Algorithm alg = Algorithm.HMAC256("0709");
                LocalDateTime expirationDate = LocalDateTime.now().plusHours(2);
                return JWT.create()
                        .withIssuer("Farmateste")
                        .withSubject(user.getUsername())
                        .withExpiresAt(expirationDate.toInstant(ZoneOffset.of("-03:00")))
                        .sign(alg);
            } catch(JWTCreationException e){
                throw new RuntimeException("Error by creating token", e);
            }
        }
}
