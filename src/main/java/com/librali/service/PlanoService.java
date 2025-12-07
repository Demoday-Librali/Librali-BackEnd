package com.librali.service;

import com.librali.model.Planos;

import java.util.List;

public interface PlanoService {
    Planos buscarPorId(Integer id);
    List<Planos> listarTodos();
    Planos criar(Planos plano);
    Planos atualizar(Integer id, Planos planoAtualizado);
    void deletar(Integer id);
}
