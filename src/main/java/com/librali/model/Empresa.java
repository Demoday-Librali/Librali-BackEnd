package com.librali.model;

import jakarta.persistence.*;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    private Integer pkIdEmpresa;

    private String descricaoEmpresa;

    @OneToOne
    @MapsId
    @JoinColumn(name = "pk_id_empresa")
    private Usuario usuario;

    // Getters e Setters
}
