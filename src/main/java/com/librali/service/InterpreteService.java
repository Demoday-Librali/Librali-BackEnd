package com.librali.service;

import com.librali.model.Usuario;
import com.librali.infrastructure.repository.InterpreteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterpreteService {

    private final InterpreteRepository repository;

    public InterpreteService(InterpreteRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Usuario salvar(Usuario interprete) {
        return repository.save(interprete);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Optional<Usuario> atualizar(Long id, Usuario novo) {
        return repository.findById(id).map(existente -> {
            existente.setNome(novo.getNome());
            existente.setEspecialidade(novo.getEspecialidade());
            return repository.save(existente);
        });
    }
}

