package com.librali.service;

import com.librali.model.Interprete;
import com.librali.repository.InterpreteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterpreteService {

    private final InterpreteRepository repository;

    public InterpreteService(InterpreteRepository repository) {
        this.repository = repository;
    }

    public List<Interprete> listarTodos() {
        return repository.findAll();
    }

    public Optional<Interprete> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Interprete salvar(Interprete interprete) {
        return repository.save(interprete);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Optional<Interprete> atualizar(Long id, Interprete novo) {
        return repository.findById(id).map(existente -> {
            existente.setNome(novo.getNome());
            existente.setEspecialidade(novo.getEspecialidade());
            return repository.save(existente);
        });
    }
}

