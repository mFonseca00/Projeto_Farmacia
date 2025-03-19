package com.farmateste.farmateste.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Classe de configuração para a aplicação.
 * Contém definições de beans que serão gerenciados pelo contexto do Spring.
 */
@Configuration // Indica que esta classe contém configurações para o contexto do Spring
public class Configurations {

    /**
     * Cria um bean do tipo ModelMapper.
     * O ModelMapper é utilizado para realizar a conversão entre entidades e DTOs.
     * 
     * retorna uma nova instância de ModelMapper
     */
    @Bean // Indica que este método retorna um bean que deve ser gerenciado pelo Spring
    public ModelMapper modelMapper(){
        return new ModelMapper(); // Retorna uma nova instância do ModelMapper
    } 
}