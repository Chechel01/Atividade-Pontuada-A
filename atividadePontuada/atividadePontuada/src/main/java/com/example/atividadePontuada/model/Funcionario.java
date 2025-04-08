package com.example.atividadePontuada.model;

import jakarta.persistence.*;

@Entity
@Table(name = "funcionario")
public class Funcionario {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // não pode ser nulo
    private String nome;
    private String cpf;
    private String dataNascimento;
    private double salario;
    private String email;

    @Enumerated(EnumType.STRING) // para armazenar o valor do enum como string no banco de dados
    private Sexo sexo;
    private Setor setor;
    private EstadoCivil estadoCivil;

    @OneToOne(cascade = CascadeType.ALL) // para criar o relacionamento de um para um
    private Endereco endereco;

    // Construtores, getters e setters
    public Funcionario() {
    }

    // Construtor com todos os parâmetros
    public Funcionario(Long id, String nome, String cpf, String dataNascimento, double salario, String email, Sexo sexo, Setor setor, EstadoCivil estadoCivil, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.salario = salario;
        this.email = email;
        this.sexo = sexo;
        this.setor = setor;
        this.estadoCivil = estadoCivil;
        this.endereco = endereco;

    }

    // Construtore getters e setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    // Método toString para exibir os dados do funcionário
    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", salario=" + salario +
                ", email='" + email + '\'' +
                ", sexo=" + sexo +
                ", setor=" + setor +
                ", estadoCivil=" + estadoCivil +
                ", endereco=" + endereco +
                '}';
    }
}
