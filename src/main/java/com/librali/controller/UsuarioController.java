package com.librali.controller;

import com.librali.mapper.UsuarioMapper;
import com.librali.model.PessoaFisica;
import com.librali.model.Planos;
import com.librali.model.Usuario;
import com.librali.records.UsuarioRequest;
import com.librali.records.UsuarioResponse;
import com.librali.repository.PessoaFisicaRepository;
import com.librali.repository.UsuarioRepository;
import com.librali.service.PlanoService;
import com.librali.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PlanoService planoService;


    @PostMapping
    public ResponseEntity<UsuarioResponse> criarUsuario(@RequestBody UsuarioRequest request) {

        Planos plano = planoService.buscarPorId(request.fkIdPlano()); // valida e retorna o plano

        Usuario usuario = UsuarioMapper.toEntity(request, plano);

        Usuario salvo = usuarioService.cadastrar(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toResponse(salvo));
    }

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> listarTodos() {
        List<Usuario> usuarios = usuarioService.listarTodos();
        return ResponseEntity.ok(usuarios.stream().map(UsuarioMapper::toResponse).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity <Usuario> pegaUsuarios(@PathVariable int id) {
        return usuarioService.buscarPorId(id)
                .map(usuario -> ResponseEntity.ok(usuario))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(
            @PathVariable Integer id,
            @RequestBody Usuario dadosAtualizados) {

        Usuario atualizado = usuarioService.atualizar(id, dadosAtualizados);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> atualizarParcial(
            @PathVariable Integer id,
            @RequestBody Map<String, Object> campos) {

        Usuario atualizado = usuarioService.atualizarParcial(id, campos);
        return ResponseEntity.ok(atualizado);
    }


}
