package com.librali.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pessoa_fisica")
public class PessoaFisica {

    @Id
    @Column (name = "pk_id_pf")
    private Integer pkIdPf;

    private String pronome;

    @Column (name = "sobre_pf")
    private String sobrePf;

    @OneToOne
    @MapsId
    @JoinColumn(name = "pk_id_pf")
    private Usuario usuario;
}
