//Aqui vai as informaç~eos que volta para o front end (questão de localização do usuario dentro da plataforma por ex)

package com.librali.records;

import java.time.LocalDate;

public record UsuarioResponse(
        Integer id, String nomeRazao, String cpfCnpj, LocalDate dataNasc,
        String email, String telefone, String cidade, String documento
) {}

