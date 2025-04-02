package com.farmateste.farmateste.config; // Pacote da classe

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Marca como classe de configuração Spring
@EnableWebSecurity // Habilita a segurança web do Spring Security
public class SecurityConfig {

    @Bean // Define um Bean gerenciado pelo Spring
    // Método que configura as regras de segurança HTTP
    public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {
        http
            // Desabilita a proteção CSRF (comum em APIs stateless)
            .csrf(csrf -> csrf.disable())
            // Configura a gestão de sessão para ser STATELESS (sem estado)
            // O servidor não criará ou usará sessões HTTP.
            // Ideal para APIs RESTful que usam tokens (ex: JWT).
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // Constrói e retorna a cadeia de filtros de segurança configurada
        return http.build();
    }
}