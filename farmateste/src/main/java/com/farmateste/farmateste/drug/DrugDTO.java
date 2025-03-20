package com.farmateste.farmateste.drug;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) para a entidade Drug.
 * Utilizado para transferir dados entre camadas da aplicação, como entre a camada de controle e a camada de serviço.
 */
@Getter // Gera os métodos getters para todos os campos
@Setter // Gera os métodos setters para todos os campos
public class DrugDTO {

    @NotBlank
    private String name; // Nome do medicamento
    private double price; // Preço ou valor do medicamento
    private long quantity; // Quantidade do medicamento disponível
    private boolean available; // Status de disponibilidade do medicamento
    private DrugType drugType; // Tipo do medicamento (ex: ANALGÉSICO, ANTIBIÓTICO)
    private PackSize packSize; // Tamanho da embalagem (ex: PEQUENO, MÉDIO, GRANDE)
}