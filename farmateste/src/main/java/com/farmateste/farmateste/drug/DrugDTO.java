package com.farmateste.farmateste.drug;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DrugDTO {

    private String name; // Nome do medicamento
    private double price; // Preço ou valor do medicamento
    private long quantity; // Quantidade do medicamento disponível
    private boolean available; // Status de disponibilidade do medicamento
    private DrugType drugType; // Tipo do medicamento (ex: ANALGÉSICO, ANTIBIÓTICO)
    private PackSize packSize; // Tamanho da embalagem (ex: PEQUENO, MÉDIO, GRANDE)
}
