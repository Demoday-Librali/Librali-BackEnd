package com.librali.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "avaliacao")
public class Avaliacao {

    @Id
    @GeneratedValue
    @Column (name = "pk_id_avaliacao")
    private Integer pkIdAval;

    private int nota;
    private String comentario;
    private LocalDateTime date_avaliacao = LocalDateTime.now();

    @OneToOne
    @MapsId
    @JoinColumn(name = "pk_id_servico")
    private Servico Solicitacao;

    @OneToOne
    @MapsId
    @JoinColumn(name = "pk_id_interprete")
    private Interprete Interprete;

    @OneToOne
    @MapsId
    @JoinColumn (name = "pk_id_usuario")
    private Usuario Avaliador;

}
