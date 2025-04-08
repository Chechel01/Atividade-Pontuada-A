package com.example.atividadePontuada.service;

import com.example.atividadePontuada.exception.EmailJaCadastradoException;
import com.example.atividadePontuada.model.Funcionario;
import com.example.atividadePontuada.repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service // Anotação para indicar que esta classe é um serviço
@Validated // Anotação para validar os métodos deste serviço
public class FuncionarioService {
    // Mapeia o caminho base para os endpoints deste controlador
    private FuncionarioRepository funcionarioRepository;

    // Construtor para injetar a dependência do FuncionarioRepository
    public FuncionarioService(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    // Método para listar todos os funcionários
    public List<Funcionario> ListarTodos(){
        return funcionarioRepository.findAll();
    }

    // Método para salvar um novo funcionário
    public Funcionario salvar(@Valid Funcionario funcionario){
        if (funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent()){
            throw new EmailJaCadastradoException("Email ja cadastrado");
        }
        return funcionarioRepository.save(funcionario);
    }

    // Método para atualizar um funcionário existente
    public Funcionario atualizar(@Valid Funcionario funcionario){
        Funcionario funcionarioAtualizar = funcionarioRepository.findById(funcionario.getId())
                .orElseThrow(() -> new IllegalArgumentException("Funcionario não encontrado"));

        funcionarioAtualizar.setNome(funcionario.getNome());
        funcionarioAtualizar.setCpf(funcionario.getCpf());
        funcionarioAtualizar.setDataNascimento(funcionario.getDataNascimento());
        funcionarioAtualizar.setEmail(funcionario.getEmail());

        return funcionarioRepository.save(funcionarioAtualizar);

    }

    // Método para excluir um funcionário
    public void excluir(Long id){
        Funcionario funcionarioExcluir = funcionarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Funcionario não encontrado"));

        funcionarioRepository.delete(funcionarioExcluir);
    }
}
