package com.librali.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pkIdUsuario;

    private String nomeRazao;
    private String cpfCnpj;
    private String tipoDocumento;
    private LocalDate dataNasc;

    private String cep;
    private String numero;
    private String rua;
    private String cidade;
    private String complemento;

    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String telefone;
    private String telefoneSecundario;

    private String imagemPerfil;

    private Integer fkIdPlano; // depois podemos mudar para Plano objeto

    private String senha;
    private String tipo; // pessoa_fisica, empresa, interprete

    private LocalDateTime dataCadastro = LocalDateTime.now();

    // Getters e Setters aqui (omiti por brevidade)
}
