package com.farmateste.farmateste.config; // Pacote da classe

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration // Marca como classe de configuração Spring
@EnableWebSecurity // Habilita a segurança web do Spring Security
@RequiredArgsConstructor
public class SecurityConfig {

    private final Filter filter;

    @Bean // Define um Bean gerenciado pelo Spring
    // Método que configura as regras de segurança HTTP
    public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {
        http
            // Desabilita CSRF (comum para APIs stateless)
            .csrf(csrf -> csrf.disable()) // Nova sintaxe lambda
            // Configura gestão de sessão como STATELESS
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            // Configura autorizações para requisições HTTP (CORRIGIDO O ENCADEAMENTO E MÉTODO)
            .authorizeHttpRequests(auth -> auth
                // Permite requisições POST para /login sem autenticação
                .requestMatchers(HttpMethod.POST, "/login").permitAll()
                // Qualquer outra requisição exige autenticação
                .anyRequest().authenticated())
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

        // Constrói e retorna a cadeia de filtros de segurança configurada
        return http.build();
    }

    @Bean // Define um Bean gerenciado pelo Spring
    // Método que expõe o AuthenticationManager como um Bean.
    // O AuthenticationManager é necessário para processar tentativas de autenticação.
    public AuthenticationManager authenticationManager
            // Recebe a configuração de autenticação padrão do Spring.
            (AuthenticationConfiguration authenticationConfiguration) throws Exception {
        // Obtém e retorna o AuthenticationManager gerenciado pelo Spring.
        // Isso permite injetá-lo em outras partes da aplicação (ex: Controller de login).
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}