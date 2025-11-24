//Aqui é só inserir as variaveis e declarar elas, técnicamente, precisaria dos Getter e Setters também, mas o Lambok faz automatico!!!!!
package com.librali.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.*;


@Entity
@Table(name = "usuario")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor //Todos gerados automatico pelo Lombok
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "pk_id_usuario")
    private Integer pkIdUsuario;

    @Column (name = "nome_razao")
    private String nomeRazao;

    @Column (name = "cpf_cnpj")
    private String cpfCnpj;

    @Column (name = "tipo_documento")
    private String Documento;

    @Column (name = "data_nasc")
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

    @Column (name = "telefone_secundario")
    private String telSecundario;

    // private String imagemPerfil; Ver como adicionar imagem

    @Column (name = "fk_id_plano")
    private Integer fkIdPlano; // depois mudar para Plano objeto

    private String senha;
    private String tipo; // pessoa_fisica, empresa, interprete

    @Column (name = "data_cadastro")
    private LocalDateTime dataCadastro = LocalDateTime.now(); //define automatico quando cadastrado

}
