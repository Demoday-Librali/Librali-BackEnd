package com.librali.controller;

import com.librali.exception.ResourceNotFoundException;
import com.librali.model.PessoaFisica;
import com.librali.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa-fisica")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @GetMapping("/usuario/{idUsuario}")
    public PessoaFisica buscarPorUsuario(@PathVariable Long idUsuario) {
        return pessoaFisicaRepository.findById(idUsuario)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa Física não encontrada"));
    }
}


    //PAREI FAZENDO A LÓGICA DO BOTÃO QUE CONFIRMA QUEM É INTERPRETE E QUEM É USUARIO COMUM
    // já fiz a lógíca, falta acertar a parte de redirecionar o usuario para sua tabela correspondente.
    //Assim depois vai funcionar a parte de get apenas interpretes!!
