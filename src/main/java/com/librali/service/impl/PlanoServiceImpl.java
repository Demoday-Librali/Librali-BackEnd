package com.librali.service.impl;

import com.librali.exception.ResourceNotFoundException;
import com.librali.model.Planos;
import com.librali.repository.PlanosRepository;
import com.librali.service.PlanoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
//Todas as operações do banco feitas ali dentro acontecem como um único pacote.
//Se der erro em qualquer parte do metodo → Rollback (volta tudo ao estado anterior).
//Se tudo der certo → Commit (salva tudo no banco).
public class PlanoServiceImpl implements PlanoService {

    private final PlanosRepository planosRepository;

    public PlanoServiceImpl(PlanosRepository planosRepository) {
        this.planosRepository = planosRepository;
    }

    @Override
    //Override diz "Este metodo aqui está substituindo um metodo que veio da superclasse ou interface."
    public Planos buscarPorId(Integer id) {
        return planosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plano não encontrado com id: " + id));
    }

    @Override
    public List<Planos> listarTodos() {
        return planosRepository.findAll();
    }

    @Override
    public Planos criar(Planos plano) {
        // aqui você pode adicionar validações (ex.: nome único, price >= 0, etc)
        return planosRepository.save(plano);
    }

    @Override
    public Planos atualizar(Integer id, Planos planoAtualizado) {
        Planos existente = buscarPorId(id);

        existente.setNomePlano(planoAtualizado.getNomePlano());
        existente.setDescricaoPlano(planoAtualizado.getDescricaoPlano());
        existente.setPreco(planoAtualizado.getPreco());
        existente.setTipoDestino(planoAtualizado.getTipoDestino());

        return planosRepository.save(existente);
    }

    @Override
    public void deletar(Integer id) {
        Planos existente = buscarPorId(id);
        // você pode checar regras (ex.: não deletar se usuários vinculados)
        planosRepository.delete(existente);
    }
}
