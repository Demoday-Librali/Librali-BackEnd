package com.librali.controller;

import com.librali.model.Usuario;
import com.librali.records.UsuarioRequest;
import com.librali.records.UsuarioResponse;
import com.librali.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public UsuarioResponse criarUsuario(@RequestBody UsuarioRequest request) {
        return usuarioService.cadastrar(request);
    }
}
