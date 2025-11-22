package com.librali.controller;

import org.springframework.web.bind.annotation.*;
import com.librali.model.Usuario;
import com.librali.infrastructure.repository.UsuarioRepository;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Integer id, @RequestBody Usuario usuario) {
        usuario.setPkIdUsuario(id);
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        usuarioRepository.deleteById(id);
    }
}
