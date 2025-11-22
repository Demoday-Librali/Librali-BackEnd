package com.librali.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "interprete")
public class Interprete {

    @Id
    private Integer pkIdInterprete;

    private String pronome;
    private String descricaoInterprete;
    private BigDecimal notaMedia;

    @OneToOne
    @MapsId
    @JoinColumn(name = "pk_id_interprete")
    private Usuario usuario;

    // Getters e Setters
}
