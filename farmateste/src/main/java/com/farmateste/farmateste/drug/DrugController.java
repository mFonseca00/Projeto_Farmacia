package com.farmateste.farmateste.drug;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(name = "/drugs")
@RequiredArgsConstructor
public class DrugController {

    private final DrugService drugService;

    @PostMapping
    public void register(@RequestBody DrugDTO dto){
        drugService.createDrug(dto);
    }

    // @PostMapping()
    // public void postMethodName(@RequestBody String entity) {
    //     //TODO: process POST request
        
    // }
    
}
