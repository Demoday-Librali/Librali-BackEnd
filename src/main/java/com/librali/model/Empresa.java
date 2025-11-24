package com.librali.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue
    private Integer pkIdEmpresa;

    private String descricaoEmpresa;

    @OneToOne
    @MapsId
    @JoinColumn(name = "pk_id_empresa")
    private Usuario usuario;
}
