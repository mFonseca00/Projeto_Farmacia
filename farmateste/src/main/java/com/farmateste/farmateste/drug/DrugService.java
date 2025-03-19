package com.farmateste.farmateste.drug;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class DrugService {

    private final DrugRepository drugRepository;

    private final ModelMapper modelMapper;
    
    
}
