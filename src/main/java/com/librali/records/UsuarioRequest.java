package com.librali.records;
//REQUEST é oq o front manda para o Backend
//RESPONSE é a resposta que o Back envia para o Front
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;


public record UsuarioRequest(String nomeRazao, String cpfCnpj, LocalDate dataNasc, Boolean confirmaIntertepre, String senha, String cep, Integer numero, String rua, String uf, String cidade, String complemento, String email, String telefone, String telSecundario, String imagemURL, MultipartFile imagem, String descricao, Integer fkIdPlano ) {}

