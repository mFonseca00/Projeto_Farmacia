package com.farmateste.farmateste.drug;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) para a entidade Drug.
 * Utilizado para transferir dados entre camadas da aplicação, como entre a camada de controle e a camada de serviço.
 */
@Getter // Gera os métodos getters para todos os campos
@Setter // Gera os métodos setters para todos os campos
public class DrugDTO {

    private Long id;
    @NotBlank
    private String name; // Nome do medicamento
    @NotBlank
    private String description;
    @NotBlank
    private String manufacturer;
    @Positive
    private double price; // Preço ou valor do medicamento
    @PositiveOrZero
    private long quantity; // Quantidade do medicamento disponível
    private boolean available; // Status de disponibilidade do medicamento
    private AdministrationRoute administrationRoute;
    private DrugType drugType; // Tipo do medicamento (ex: ANALGÉSICO, ANTIBIÓTICO)
    private PackSize packSize; // Tamanho da embalagem (ex: PEQUENO, MÉDIO, GRANDE)
}