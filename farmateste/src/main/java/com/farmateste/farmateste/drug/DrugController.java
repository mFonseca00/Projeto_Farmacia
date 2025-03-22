package com.farmateste.farmateste.drug;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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
    public DrugDTO getByIdDrugs(@PathVariable @NotNull Long id){
        return drugService.readById(id);
    }

    @PutMapping("/{id}")
    public DrugDTO updateDrug(@PathVariable @NotNull Long id, @RequestBody @Valid DrugDTO dto){
        return drugService.updateDrugInfo(dto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteDrugById(@PathVariable @NotNull Long id){
        drugService.deleteDrug(id);
    }
}
