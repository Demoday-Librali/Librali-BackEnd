package com.librali.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "planos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Planos{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id_plano")
    private Integer pkIdPlano;

    @Column(name = "nome_plano")
    private String nomePlano;

    @Column(name = "descricao")
    private String descricaoPlano;

    private Float preco;

    @Column(name = "tipo_destino")
    private String tipoDestino;

    @JsonIgnoreProperties("plano")
    @OneToMany(mappedBy = "plano")
    private List<Usuario> usuarios;

}
