package com.farmateste.farmateste.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCredentialsDTO {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
