package com.farmateste.farmateste.drug;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<DrugDTO> readAllDrugs(Pageable page) {
        return drugRepository.findAll(page).map(d -> modelMapper.map(d, DrugDTO.class));
    }

    public DrugDTO readById(Long id){
        Drug drug = drugRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        return modelMapper.map(drug, DrugDTO.class);
    }

    public DrugDTO updateDrugInfo(DrugDTO dto, Long id){
        Drug drug = modelMapper.map(dto, Drug.class);
        drug.setId(id);
        drug = drugRepository.save(drug);  
        return modelMapper.map(drug, DrugDTO.class);
    }

    public void deleteDrug(Long id){
        drugRepository.deleteById(id);
    }
}