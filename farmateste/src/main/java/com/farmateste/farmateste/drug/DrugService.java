package com.farmateste.farmateste.drug;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * Classe de serviço para gerenciar operações relacionadas a medicamentos.
 * Utiliza o padrão de projeto Service e é anotada com @Service para ser gerenciada pelo Spring.
 */
@Service // Indica que esta classe é um serviço Spring e pode ser injetada em outros componentes
@RequiredArgsConstructor // Gera um construtor com todos os campos finais como parâmetros, facilitando a injeção de dependências
public class DrugService {

    private final DrugRepository drugRepository; // Repositório para operações de CRUD com medicamentos

    private final ModelMapper modelMapper; // Utilizado para conversão entre entidades e DTOs

    // Aqui podem ser adicionados métodos para manipular dados de medicamentos usando drugRepository e modelMapper.
}