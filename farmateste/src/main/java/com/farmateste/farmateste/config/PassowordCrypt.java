package com.farmateste.farmateste.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassowordCrypt {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String encryption(String password){
        return encoder.encode(password);
    }

}
