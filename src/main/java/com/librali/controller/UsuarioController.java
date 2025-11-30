package com.librali.controller;

import com.librali.model.Usuario;
import com.librali.records.UsuarioRequest;
import com.librali.records.UsuarioResponse;
import com.librali.repository.UsuarioRepository;
import com.librali.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public UsuarioResponse criarUsuario(@RequestBody UsuarioRequest request) {
        return usuarioService.cadastrar(request);
    }

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> pegaUsuarios() {
        return usuarioRepository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(
            @PathVariable Integer id,
            @RequestBody Usuario dadosAtualizados) {

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Usuario usuario = usuarioOptional.get();

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

        Usuario atualizado = usuarioRepository.save(usuario);

        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Integer id) {
        if (!usuarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> atualizarParcial(
            @PathVariable Integer id,
            @RequestBody Map<String, Object> campos) {

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Usuario usuario = usuarioOptional.get();

        campos.forEach((campo, valor) -> {
            Field field = ReflectionUtils.findField(Usuario.class, campo);
            if (field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, usuario, valor);
            }
        });

        Usuario atualizado = usuarioRepository.save(usuario);

        return ResponseEntity.ok(atualizado);
    }

}
