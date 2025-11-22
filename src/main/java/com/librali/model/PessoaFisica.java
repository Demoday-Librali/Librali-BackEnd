package com.librali.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica {

    @Id
    private Integer pkIdPf;

    private String pronome;
    private String sobrePf;

    @OneToOne
    @MapsId
    @JoinColumn(name = "pk_id_pf")
    private Usuario usuario;

    // Getters e Setters
}
