package com.farmateste.farmateste.drug;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe que representa uma entidade Medicamento com suas propriedades e características.
 */
@Entity // Indica que esta classe é uma entidade JPA
@Table(name = "Drug") // Especifica o nome da tabela no banco de dados associada a esta entidade
@Data // Gera getters e setters para todos os campos, além de toString, equals e hashCode
@AllArgsConstructor // Gera um construtor que aceita todos os campos como parâmetros
@NoArgsConstructor // Gera um construtor padrão sem parâmetros, necessário para o JPA
public class Drug {
    @Id // Marca o campo id como a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica que o valor do id será gerado automaticamente pelo banco de dados
    private Long id; // Identificador único para o medicamento

    private String name; // Nome do medicamento

    private double price; // Preço ou valor do medicamento

    private long quantity; // Quantidade do medicamento disponível

    private boolean available; // Status de disponibilidade do medicamento

    @Enumerated(EnumType.STRING) // Especifica que o tipo de medicamento será armazenado como uma string no banco de dados
    private DrugType drugType; // Tipo do medicamento (ex: ANALGÉSICO, ANTIBIÓTICO)

    @Enumerated(EnumType.STRING) // Especifica que o tamanho da embalagem será armazenado como uma string no banco de dados
    private PackSize packSize; // Tamanho da embalagem (ex: PEQUENO, MÉDIO, GRANDE)

    // Será necessário um DTO (Data Transfer Object) para filtrar e passar apenas os dados necessários para o cliente
}