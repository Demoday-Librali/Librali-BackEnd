//Aqui fica a Lógica das rotas
package com.librali.service;

import com.librali.model.Planos;
import com.librali.model.Usuario;
import com.librali.records.UsuarioRequest;
import com.librali.records.UsuarioResponse;
import com.librali.repository.UsuarioRepository;
import com.librali.repository.PlanosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PlanosRepository planosRepository;

    public UsuarioResponse cadastrar(UsuarioRequest request) {

        Usuario usuario = new Usuario();

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

        String documento = usuario.getCpfCnpj();

        // Detectar tipo de documento
        if (documento != null) {
            if (documento.length() == 11) {
                usuario.setDocumento("CPF");
            } else if (documento.length() == 14) {
                usuario.setDocumento("CNPJ");
            } else {
                usuario.setDocumento("Informe um CPF ou um CNPJ");
            }
        }

        // LÓGICA DOS PLANOS
        if (documento.length() == 11) {

            // CPF = recebe automaticamente o plano gratuito
            Planos planoGratuito = planosRepository.findById(1)
                    .orElseThrow(() -> new RuntimeException("Plano gratuito não encontrado no banco"));

            usuario.setPlano(planoGratuito);

        } else {

            // CNPJ = precisa enviar o id do plano
            if (request.fkIdPlano() == null) {
                throw new RuntimeException("Empresa precisa escolher um plano para concluir o cadastro.");
            }

            Planos planoEscolhido = planosRepository.findById(request.fkIdPlano())
                    .orElseThrow(() -> new RuntimeException("Plano informado não existe."));

            usuario.setPlano(planoEscolhido);
        }

        // salva o usuário (com plano padrão ou com o plano escolhido)
        Usuario salvo = usuarioRepository.save(usuario);

        // Retorna o Response
        return new UsuarioResponse(
                salvo.getPkIdUsuario(),
                salvo.getNomeRazao(),
                salvo.getCpfCnpj(),
                salvo.getDataNasc(),
                salvo.getEmail(),
                salvo.getTelefone(),
                salvo.getCidade(),
                salvo.getDocumento()
        );
    }
}
