package com.farmateste.farmateste.drug;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/drugs")
@RequiredArgsConstructor
public class DrugController {

    private final DrugService drugService;

    @PostMapping
    public void registerDrug(@RequestBody @Valid DrugDTO dto){
        drugService.createDrug(dto);
    }

    @GetMapping()
    public List<DrugDTO> getAllDrugs() {
        return drugService.readAllDrugs();
    }

    @GetMapping("/{id}")
        public DrugDTO getByIdDrugs(@PathVariable Long id){
        return drugService.readById(id);
    }
    
}
