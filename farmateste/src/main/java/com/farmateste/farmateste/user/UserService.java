package com.farmateste.farmateste.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service // Marca como um serviço Spring.
@RequiredArgsConstructor // Gera construtor para injeção do 'repository'.
// Classe que busca dados do usuário para o Spring Security autenticar.
public class UserService implements UserDetailsService {

    // Repositório para acessar dados dos usuários.
    private final UserRepository repository;

    // Método chamado pelo Spring Security para carregar um usuário pelo nome.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Busca o usuário no repositório usando o username fornecido.
        // Retorna os detalhes do usuário (UserDetails) para o Spring Security.
        return repository.findByUsername(username);
    }
}