package com.farmateste.farmateste.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> registerDrug(@RequestBody @Valid UserDTO dto, UriComponentsBuilder uriBuilder){
        UserDTO userDTO = userService.createUser(dto);
        URI adress = uriBuilder.path("/users/{id}").buildAndExpand(userDTO.getId()).toUri();
        return ResponseEntity.created(adress).body(userDTO);
    }
    
}
