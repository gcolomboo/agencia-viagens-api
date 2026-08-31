package com.agencia.viagens.controller;

import com.agencia.viagens.model.Avaliacao;
import com.agencia.viagens.model.Destino;
import com.agencia.viagens.service.DestinoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destinos")
public class DestinoController {

    private final DestinoService destinoService;

    public DestinoController(DestinoService destinoService) {
        this.destinoService = destinoService;
    }

    // LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<Destino>> listar() {
        return ResponseEntity.ok(destinoService.listarTodos());
    }

    // PESQUISAR POR NOME OU LOCALIZAÇÃO
    @GetMapping("/buscar")
    public ResponseEntity<List<Destino>> buscar(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String localizacao) {
        return ResponseEntity.ok(destinoService.buscar(nome, localizacao));
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Destino> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(destinoService.buscarPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // CADASTRAR
    @PostMapping
    public ResponseEntity<Destino> criar(@RequestBody Destino destino) {
        Destino novo = destinoService.criar(destino);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<Destino> atualizar(@PathVariable Long id,
                                             @RequestBody Destino atualizado) {
        try {
            return ResponseEntity.ok(destinoService.atualizar(id, atualizado));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // REGISTRAR AVALIAÇÃO
    @PostMapping("/{id}/avaliacoes")
    public ResponseEntity<?> avaliar(@PathVariable Long id,
                                     @RequestBody Avaliacao avaliacao) {
        try {
            return ResponseEntity.ok(destinoService.avaliar(id, avaliacao));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // EXCLUIR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        try {
            destinoService.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
