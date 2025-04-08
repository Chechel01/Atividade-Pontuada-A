package com.example.atividadePontuada.controller;

import com.example.atividadePontuada.model.Funcionario;
import com.example.atividadePontuada.repository.FuncionarioRepository;
import com.example.atividadePontuada.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController // Anotação para indicar que esta classe é um controlador REST
@RequestMapping("/funcionario") // Define o caminho base para os endpoints deste controlador
public class FuncionarioController {

    // Mapeia o caminho base para os endpoints deste controlador
    private FuncionarioService funcionarioService;

    // Construtor para injetar a dependência do FuncionarioService
    public FuncionarioController(FuncionarioService funcionarioService){
        this.funcionarioService = funcionarioService;
    }

    // Endpoint para listar todos os funcionarios
    @GetMapping
    public List<Funcionario> ListarTudo(){
        return funcionarioService.ListarTodos();
    }

    // Endpoint para listar um funcionario específico
    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Funcionario funcionario){
        funcionarioService.salvar(funcionario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Funcionario cadastrado com sucesso"));
    }

    // Endpoint para atualizar um funcionario
    @PutMapping
    public ResponseEntity<Map<String, Object>> atualizar(@Valid @RequestBody Funcionario funcionario){
        funcionarioService.atualizar(funcionario);
        return ResponseEntity
                .ok()
                .body(Map.of("mensagem", "Funcionario atualizado com sucesso"));
    }

    // Endpoint para excluir um funcionario
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable Long id){
        funcionarioService.excluir(id);
        return ResponseEntity
                .ok()
                .body(Map.of("mensagem", "Funcionario deletado com sucesso"));
    }


}
