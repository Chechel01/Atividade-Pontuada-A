package com.example.atividadePontuada.repository;

import com.example.atividadePontuada.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // Anotação para indicar que esta interface é um repositório
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Optional<Funcionario> findByEmail(String email); // Método para buscar um funcionário pelo email
}
