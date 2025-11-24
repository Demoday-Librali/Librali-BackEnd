package com.librali.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "servico")
public class Servico {

    @Id
    @GeneratedValue
    @Column (name = "pk_id_servico")
    private Integer pkServico;

    @Column(name = "descricao")
    private String descricaoServ;

    @Column(name = "data_solicitacao")
    private Date solicitacaoServ;

    @Column(name = "status_serv")
    private String statusServ;

    @OneToOne
    @MapsId
    @JoinColumn(name = "pk_id_interprete")
    private Interprete Interprete;

    @OneToOne
    @MapsId
    @JoinColumn(name = "pk_id_usuario")
    private Usuario Solicitante;
}
