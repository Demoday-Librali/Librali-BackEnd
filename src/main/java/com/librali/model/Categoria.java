package com.librali.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categoria")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue
    @Column(name = "pk_id_categoria")
    private Integer pkIdCategoria;

    @Column (name = "nome")
    private String nomeCateg;

    @Column (name = "descricao")
    private String descricaoCateg;
}
