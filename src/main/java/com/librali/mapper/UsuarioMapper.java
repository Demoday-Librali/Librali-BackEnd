//O Mapper é criado para converter
//Request para Entidade (Pasara salvar no banco de ddados)
// Entidade para Response (Para devoler ao front apenas oq importa)
package com.librali.mapper;

import com.librali.model.Planos;
import com.librali.model.Usuario;
import com.librali.records.UsuarioRequest;
import com.librali.records.UsuarioResponse;

public class UsuarioMapper {

    //Request --> Entidade
    public static Usuario toEntity(UsuarioRequest request, Planos plano) {

        Usuario usuario = new Usuario();

        usuario.setPkIdUsuario(null);

        usuario.setNomeRazao(request.nomeRazao());
        usuario.setCpfCnpj(request.cpfCnpj());
        usuario.setDataNasc(request.dataNasc());
        usuario.setSenha(request.senha());

        usuario.setCep(request.cep());
        usuario.setNumero(request.numero());
        usuario.setRua(request.rua());
        usuario.setUf(request.uf());
        usuario.setCidade(request.cidade());
        usuario.setComplemento(request.complemento());

        usuario.setEmail(request.email());
        usuario.setTelefone(request.telefone());
        usuario.setTelSecundario(request.telSecundario());

        usuario.setDescricaoUser(request.descricao());

        // FK → objeto Planos
        usuario.setPlano(plano);

        return usuario;
    }

    //Entidade --> Response
    public static UsuarioResponse toResponse(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getPkIdUsuario(),
                usuario.getNomeRazao(),
                usuario.getCpfCnpj(),
                usuario.getDataNasc(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getCidade(),
                usuario.getDocumento()
        );
    }
}

