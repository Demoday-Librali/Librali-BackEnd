package com.librali.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

import lombok.*;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "interprete")
public class Interprete {

    @Id
    @GeneratedValue
    @Column (name="pk_id_interprete")
    private Integer pkIdInterprete;

    private String pronome;

    @Column (name = "descricao_interprete")
    private String descInter;
    private BigDecimal nota_media;

    @OneToOne
    @MapsId
    @JoinColumn(name = "pk_id_interprete")
    private Usuario Usuario;
}
