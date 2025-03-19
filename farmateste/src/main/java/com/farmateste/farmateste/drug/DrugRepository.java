package com.farmateste.farmateste.drug;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface que representa o repositório para a entidade Drug.
 * Extende JpaRepository para fornecer operações CRUD (Create, Read, Update, Delete) de forma simplificada.
 */
public interface DrugRepository extends JpaRepository<Drug, Long> {
    // Não é necessário implementar métodos, pois JpaRepository fornece a implementação padrão.
    // Métodos adicionais podem ser declarados aqui, se necessário.
}