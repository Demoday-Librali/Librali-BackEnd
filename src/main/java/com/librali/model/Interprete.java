package com.librali.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity // diz que essa classe vira uma tabela
@Table(name = "interprete") // nome da tabela no MySQL
@Data // cria automaticamente GET/SET, toString, equals, hashCode
public class Interprete {

    @Id // chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto incremento
    private Long id;

    private String nome;

    private String especialidade;

    // GETTERS E SETTERS

    public Long getId() {
        return id;
    }

    // não coloca setId porque ele é auto gerado pelo banco.

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
