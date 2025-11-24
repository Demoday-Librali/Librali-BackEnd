package com.librali.records;
//REQUEST é oq o front manda para o Backend
//RESPONSE é a resposta que o front envia para o Front
import java.time.LocalDate;

public record UsuarioRequest(String nomeRazao, String cpfCnpj, LocalDate dataNasc, String senha, String cep, Integer numero, String rua, String uf, String cidade, String complemento, String email, String telefone, String telSecundario, /*Imagem URL */ String descricao, Integer fkIdPlano ) {}

