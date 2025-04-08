package com.example.atividadePontuada.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Anotação para indicar que esta classe é um controlador REST
public class WelcomeController {

    // Mapeia a raiz do aplicativo
    @GetMapping("/")
    public String Welcome(){
        return "Bem-vindo ao sistema de cadastro de funcionarios";
    }

    // Mapeia o endpoint "/Dev"
    @GetMapping("/Dev")
    public String getDev(){
        return "Desenvolvedor: Michel Linhares";
    }

}
