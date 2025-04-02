package com.farmateste.farmateste.config;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.farmateste.farmateste.user.UserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Filter extends OncePerRequestFilter{

    private final TokenService tokenService;

    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {   
                    String tokenJWT = findToken(request);
                    if(tokenJWT != null){
                        var userLogin = tokenService.findUserInToken(tokenJWT);
                        var user = userRepository.findByUsername(userLogin);
                        var authenticator = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                        SecurityContextHolder.getContext().setAuthentication(authenticator);
                    }
                    
                    filterChain.doFilter(request, response);
    }

    private String findToken(HttpServletRequest request){
        var authorization = request.getHeader("Authorization");
        if(authorization != null){
            return authorization.replace("Bearer ", "");
        } 
        return null;
    }

}
