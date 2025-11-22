package com.librali.controller;

import com.librali.model.Interprete; // modelo (crie depois se ainda não tiver)
import com.librali.service.InterpreteService; // serviço (criar depois)
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // diz que essa classe responde requisições REST e já converte/retorna JSON
@RequestMapping("/interpretes") // rota base
@CrossOrigin // permite requisições de outras origens (opcional, útil para front-end)
public class InterpreteController {

    private final InterpreteService service; // injeção por construtor

    // Construtor — o Spring injeta automaticamente uma instância do service
    public InterpreteController(InterpreteService service) {
        this.service = service;
    }

    @GetMapping("/teste")
    public String teste() {
        return "API funcionando!";
    }

    // GET /interpretes  -> lista todos
    @GetMapping
    public ResponseEntity<List<Interprete>> listar() {
        List<Interprete> lista = service.listarTodos();
        return ResponseEntity.ok(lista); // 200 OK com a lista no corpo
    }

    // GET /interpretes/{id} -> busca por id
    @GetMapping("/{id}")
    public ResponseEntity<Interprete> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)              // 200 com o objeto
                .orElse(ResponseEntity.notFound().build()); // 404 se não existir
    }

    // POST /interpretes -> cria um novo interprete
    @PostMapping
    public ResponseEntity<Interprete> criar(@RequestBody Interprete interprete) {
        Interprete criado = service.salvar(interprete);
        return ResponseEntity.status(201).body(criado); // 201 Created
    }

    // DELETE /interpretes/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    // PUT /interpretes/{id} -> atualizar (simples)
    @PutMapping("/{id}")
    public ResponseEntity<Interprete> atualizar(@PathVariable Long id,
                                                @RequestBody Interprete novoInterprete) {
        return service.atualizar(id, novoInterprete)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
