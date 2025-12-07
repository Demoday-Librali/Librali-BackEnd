//Aqui fica a Lógica das rotas
package com.librali.service.impl;

import com.librali.exception.ResourceNotFoundException;
import com.librali.model.Planos;
import com.librali.model.Usuario;
import com.librali.repository.PlanosRepository;
import com.librali.repository.UsuarioRepository;
import com.librali.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PlanosRepository planosRepository;

    @Override
    public Usuario cadastrar(Usuario usuario) {

        String documento = usuario.getCpfCnpj();

        // Detectar tipo (CPF ou CNPJ)
        if (documento != null) {
            if (documento.length() == 11) {
                usuario.setDocumento("CPF");
            } else if (documento.length() == 14) {
                usuario.setDocumento("CNPJ");
            } else {
                throw new RuntimeException("Documento inválido. Informe CPF ou CNPJ.");
            }
        }

        // Lógica dos planos
        if ("CPF".equals(usuario.getDocumento())) {

            // CPF sempre recebe plano gratuito (id = 1)
            Planos planoGratuito = planosRepository.findById(1)
                    .orElseThrow(() -> new RuntimeException("Plano gratuito não encontrado."));
            usuario.setPlano(planoGratuito);

        } else {
            if (usuario.getPlano() == null) {
                throw new RuntimeException("CNPJ precisa enviar o id de um plano.");
            }
        }

        if (usuario.getDataCadastro() == null) {
            usuario.setDataCadastro(java.time.LocalDateTime.now());
        }

        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }


    @Override
    public Optional<Usuario> buscarPorId(Integer id) {
        return usuarioRepository.findById(id);
    }


    public Usuario atualizar(Integer id, Usuario dadosAtualizados) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        usuario.setNomeRazao(dadosAtualizados.getNomeRazao());
        usuario.setCpfCnpj(dadosAtualizados.getCpfCnpj());
        usuario.setDocumento(dadosAtualizados.getDocumento());
        usuario.setDataNasc(dadosAtualizados.getDataNasc());
        usuario.setSenha(dadosAtualizados.getSenha());
        usuario.setCep(dadosAtualizados.getCep());
        usuario.setNumero(dadosAtualizados.getNumero());
        usuario.setRua(dadosAtualizados.getRua());
        usuario.setUf(dadosAtualizados.getUf());
        usuario.setCidade(dadosAtualizados.getCidade());
        usuario.setComplemento(dadosAtualizados.getComplemento());
        usuario.setEmail(dadosAtualizados.getEmail());
        usuario.setTelefone(dadosAtualizados.getTelefone());
        usuario.setTelSecundario(dadosAtualizados.getTelSecundario());
        usuario.setDescricaoUser(dadosAtualizados.getDescricaoUser());
        usuario.setPlano(dadosAtualizados.getPlano());

        return usuarioRepository.save(usuario);
    }


        @Override
        public void deletar(Integer id) {
            // Verificar se o usuario existe
            Usuario usuario = usuarioRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
            // Deletar
            usuarioRepository.delete(usuario);
        }


    @Override
    public Usuario atualizarParcial(Integer id, Map<String, Object> campos) {

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado"); // pode ser sua exception
        }

        Usuario usuario = usuarioOptional.get();

        campos.forEach((campo, valor) -> {
            Field field = ReflectionUtils.findField(Usuario.class, campo);
            if (field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, usuario, valor);
            }
        });

        return usuarioRepository.save(usuario);
    }
}
