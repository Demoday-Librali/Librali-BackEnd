//Aqui é só inserir as variaveis e declarar elas, técnicamente, precisaria dos Getter e Setters também, mas o Lambok faz automatico!!!!!
package com.librali.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.librali.model.Planos;

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
    private String documento;

    @Column (name = "data_nasc")
    private LocalDate dataNasc;

    private String senha;

    private String cep;
    private Integer numero;
    private String rua;
    private String uf;
    private String cidade;
    private String complemento;

    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String telefone;

    @Column (name = "telefone_secundario")
    private String telSecundario;

    // private String imagemPerfil; Ver como adicionar imagem usando serviço de armazenamento!!

    @Column(name= "descricao_usuario")
    private String descricaoUser;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "pk_id_plano", nullable = false)
    private Planos plano;

    /*private String tipo; // pessoa_fisica, empresa*/

    @Column (name = "data_cadastro")
    private LocalDateTime dataCadastro = LocalDateTime.now(); //define automatico quando cadastrado

}
