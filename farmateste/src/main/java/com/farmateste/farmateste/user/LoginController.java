package com.farmateste.farmateste.user;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmateste.farmateste.config.TokenService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController // Controller REST
@RequiredArgsConstructor // Injeta 'auth' via construtor
@RequestMapping("/login") // Mapeia para "/login"
public class LoginController {

    // Gerenciador de autenticação do Spring Security
    private final AuthenticationManager auth;

    private final TokenService tokenService;

    @PostMapping // Responde a POST /login
    // Recebe credenciais (DTO), valida e tenta autenticar
    public ResponseEntity userCredentialsValidation(@RequestBody @Valid UserCredentialsDTO credentials) {
        // Cria token com usuário/senha
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword());

        // Tenta autenticar usando o AuthenticationManager.
        // Lança exceção se inválido.
        Authentication authentication = auth.authenticate(token);

        // Se autenticado com sucesso, retorna 200 OK.
        return ResponseEntity.ok(tokenService.createToken((User) authentication.getPrincipal()));
    }
}