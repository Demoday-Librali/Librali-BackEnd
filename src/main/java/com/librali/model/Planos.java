package com.librali.model;

import jakarta.persistence.*;

import lombok.*;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Planos {
    @Id
    @GeneratedValue
    @Column (name = "pk_id_plano")
    private Integer pkIdPlano;

    @Column (name = "nome_plano")
    private String nomePlano;

    @Column (name = "descricao")
    private String descricaoPlano;

    private Float preco;

    @Column (name = "tipo_destino")
    private String tipoDestino;
}
