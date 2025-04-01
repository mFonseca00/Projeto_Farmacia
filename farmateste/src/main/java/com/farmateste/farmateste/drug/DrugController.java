package com.farmateste.farmateste.drug;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import java.net.URI;

@RestController
@RequestMapping("/drugs")
@RequiredArgsConstructor
public class DrugController {

    private final DrugService drugService;

    @PostMapping
    public ResponseEntity<DrugDTO> registerDrug(@RequestBody @Valid DrugDTO dto, UriComponentsBuilder uriBuilder){
        DrugDTO drugDTO = drugService.createDrug(dto);
        URI adress = uriBuilder.path("/drugs/{id}").buildAndExpand(drugDTO.getId()).toUri();
        return ResponseEntity.created(adress).body(drugDTO);
    }

    @GetMapping
    public ResponseEntity<Page<DrugDTO>> getAllDrugs(@PageableDefault(size = 10) Pageable page) {
        Page<DrugDTO> drugs = drugService.readAllDrugs(page);
        return ResponseEntity.ok(drugs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DrugDTO> getByIdDrugs(@PathVariable @NotNull Long id){
        DrugDTO drugDTO = drugService.readById(id);
        return ResponseEntity.ok(drugDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DrugDTO> updateDrug(@PathVariable @NotNull Long id, @RequestBody @Valid DrugDTO dto){
        DrugDTO updatedDrugDTO = drugService.updateDrugInfo(dto, id);
        return ResponseEntity.ok(updatedDrugDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDrugById(@PathVariable @NotNull Long id){
        drugService.deleteDrug(id);
        return ResponseEntity.noContent().build();
    }
}
