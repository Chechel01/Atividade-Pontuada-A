package com.example.atividadePontuada.repository;

import com.example.atividadePontuada.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Anotação para indicar que esta interface é um repositório
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
