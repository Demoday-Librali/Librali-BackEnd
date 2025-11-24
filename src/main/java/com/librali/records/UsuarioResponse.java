package com.librali.records;

import java.time.LocalDate;

public record UsuarioResponse(
        Integer id, String nomeRazao, String cpfCnpj, LocalDate dataNasc,
        String email, String telefone, String cidade, String documento
) {}

