package com.farmateste.farmateste.drug;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public Page<DrugDTO> getAllDrugs(@PageableDefault(size = 10) Pageable page) {
        return drugService.readAllDrugs(page);
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
