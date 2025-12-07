package com.librali.service;

import com.librali.model.Usuario;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UsuarioService {

    Usuario cadastrar(Usuario usuario);

    List<Usuario> listarTodos();

    Optional<Usuario> buscarPorId(Integer id);

    public Usuario atualizar(Integer id, Usuario dadosAtualizados);

    Usuario atualizarParcial(Integer id, Map<String, Object> campos);

    void deletar(Integer id);
}
