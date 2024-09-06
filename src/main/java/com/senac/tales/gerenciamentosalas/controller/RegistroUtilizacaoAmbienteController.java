package com.senac.tales.gerenciamentosalas.controller;

import com.senac.tales.gerenciamentosalas.entity.RegistroUtilizacaoAmbiente;
import com.senac.tales.gerenciamentosalas.service.RegistroUtilizacaoAmbienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registro-utilizacao-ambiente")
public class RegistroUtilizacaoAmbienteController {

    private final RegistroUtilizacaoAmbienteService registroUtilizacaoAmbienteService;

    public RegistroUtilizacaoAmbienteController(RegistroUtilizacaoAmbienteService registroUtilizacaoAmbienteService) {
        this.registroUtilizacaoAmbienteService = registroUtilizacaoAmbienteService;
    }

    @GetMapping
    public ResponseEntity<List<RegistroUtilizacaoAmbiente>> listarTodos() {
        List<RegistroUtilizacaoAmbiente> lista = registroUtilizacaoAmbienteService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroUtilizacaoAmbiente> listarPorId(@PathVariable Integer id) {
        return registroUtilizacaoAmbienteService.listarPorId(id);
    }

    @PostMapping
    public ResponseEntity<RegistroUtilizacaoAmbiente> criar(@RequestBody RegistroUtilizacaoAmbiente registroUtilizacaoAmbiente) {
        return registroUtilizacaoAmbienteService.salvarOuAtualizar(registroUtilizacaoAmbiente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroUtilizacaoAmbiente> atualizar(@PathVariable Integer id, @RequestBody RegistroUtilizacaoAmbiente registroUtilizacaoAmbiente) {
        registroUtilizacaoAmbiente.setRegistro_utilizacao_ambiente_id(id);
        return registroUtilizacaoAmbienteService.salvarOuAtualizar(registroUtilizacaoAmbiente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagar(@PathVariable Integer id) {
        return registroUtilizacaoAmbienteService.apagar(id);
    }

    @PatchMapping("/{id}/logico")
    public ResponseEntity<Void> apagarLogicamente(@PathVariable Integer id) {
        return registroUtilizacaoAmbienteService.apagarLogicamente(id);
    }
}
