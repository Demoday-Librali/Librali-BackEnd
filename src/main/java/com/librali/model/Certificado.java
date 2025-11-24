package com.librali.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "certificado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Certificado {

    @Id
    @GeneratedValue
    @Column (name = "pk_id_certificado")
    private Integer pkIdCert;

    @Column (name = "nome_certificado")
    private String nomeCert;
    private String instituicao;
    private Date data_emissao;
    private Date data_validade;
    //arquivo certificado (ver como colocar imagens)

    @OneToOne
    @MapsId
    @JoinColumn(name = "pk_id_interprete")
    private Interprete Interprete;

    @OneToOne
    @MapsId
    @JoinColumn(name = "pk_id_categoria")
    private Categoria Categoria;
}
