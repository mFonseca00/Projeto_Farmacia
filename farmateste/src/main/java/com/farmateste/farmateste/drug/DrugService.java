package com.farmateste.farmateste.drug;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
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

    // Métodos para manipular dados de medicamentos usando drugRepository e modelMapper.

    public DrugDTO createDrug(DrugDTO dto){
        Drug drug = modelMapper.map(dto, Drug.class);
        drugRepository.save(drug);

        return modelMapper.map(drug, DrugDTO.class);
    }

    public List<DrugDTO> readAllDrugs() {
        return drugRepository.findAll().stream().map(d -> modelMapper.map(d, DrugDTO.class)).collect(Collectors.toList());
    }

    public DrugDTO readById(Long id){
        Drug drug = drugRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        return modelMapper.map(drug, DrugDTO.class);
    }
}