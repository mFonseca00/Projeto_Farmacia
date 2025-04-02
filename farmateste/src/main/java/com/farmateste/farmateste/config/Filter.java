package com.farmateste.farmateste.config;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Filter extends OncePerRequestFilter{

    private final TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {   
                    String tokenJWT = findToken(request);
                    String userLogin = tokenService.findUserInToken(tokenJWT);
                    filterChain.doFilter(request, response);
    }

    private String findToken(HttpServletRequest request){
        var authorization = request.getHeader("Authorization");
        if(authorization == null){
            throw new RuntimeException("Token not found.");
        }
        return authorization.replace("Bearer ", "");
    }

}
