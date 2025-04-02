package com.farmateste.farmateste.user;

import java.util.Collection;
import java.util.List;        // Import para List

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority; // Para criar autoridades simples
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "users")
@Data // Lombok: Gera getters, setters, equals, hashCode, toString
@AllArgsConstructor // Lombok: Gera construtor com todos os argumentos
@NoArgsConstructor // Lombok: Gera construtor sem argumentos (necessário para JPA)
public class User implements UserDetails { // Implementa a interface UserDetails

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    // --- Métodos da Interface UserDetails ---

    /**
     * Retorna as autoridades (roles/permissions) concedidas ao usuário.
     * Em uma aplicação real, isso geralmente viria de um relacionamento
     * com uma entidade Role ou de um campo na própria tabela User.
     * Para simplificar, vamos retornar uma lista vazia ou uma role padrão.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Exemplo simples: Retornar uma única role "ROLE_USER" para todos.
        // Adapte conforme sua lógica de roles/autoridades.
        // Se você não tiver roles definidas ainda, pode retornar Collections.emptyList();
        // mas muitas configurações do Spring Security esperam pelo menos uma autoridade.
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        // return Collections.emptyList(); // Alternativa se nenhuma role for necessária inicialmente
    }

    /**
     * Retorna a senha usada para autenticar o usuário.
     * O Lombok @Data já gera o getter getPassword(), mas adicionar @Override
     * confirma que estamos satisfazendo o contrato da interface.
     */
    @Override
    public String getPassword() {
        return this.password;
    }

    /**
     * Retorna o nome de usuário usado para autenticar o usuário.
     * O Lombok @Data já gera o getter getUsername().
     */
    @Override
    public String getUsername() {
        return this.username;
    }

    /**
     * Indica se a conta do usuário expirou. Uma conta expirada não pode ser
     * autenticada.
     * Retornar 'true' significa que a conta é válida (não expirou).
     * Adicione lógica (ex: verificar uma data de expiração) se necessário.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true; // Por padrão, consideramos que a conta não expira
    }

    /**
     * Indica se o usuário está bloqueado ou desbloqueado. Um usuário bloqueado
     * não pode ser autenticado.
     * Retornar 'true' significa que a conta não está bloqueada.
     * Adicione lógica (ex: verificar um campo 'locked' no banco) se necessário.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true; // Por padrão, consideramos que a conta não está bloqueada
    }

    /**
     * Indica se as credenciais do usuário (senha) expiraram. Senhas expiradas
     * impedem a autenticação.
     * Retornar 'true' significa que as credenciais são válidas (não expiraram).
     * Adicione lógica (ex: verificar data de expiração da senha) se necessário.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Por padrão, consideramos que as credenciais não expiram
    }

    /**
     * Indica se o usuário está habilitado ou desabilitado. Um usuário desabilitado
     * não pode ser autenticado.
     * Retornar 'true' significa que o usuário está habilitado.
     * Adicione lógica (ex: verificar um campo 'enabled' no banco) se necessário.
     */
    @Override
    public boolean isEnabled() {
        return true; // Por padrão, consideramos que o usuário está habilitado
    }
}