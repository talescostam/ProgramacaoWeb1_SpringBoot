package com.senac.tales.gerenciamentosalas.controller;

import com.senac.tales.gerenciamentosalas.entity.PlanejamentoAlocacao;
import com.senac.tales.gerenciamentosalas.service.PlanejamentoAlocacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planejamento-alocacao")
public class PlanejamentoAlocacaoController {

    private final PlanejamentoAlocacaoService planejamentoAlocacaoService;

    public PlanejamentoAlocacaoController(PlanejamentoAlocacaoService planejamentoAlocacaoService) {
        this.planejamentoAlocacaoService = planejamentoAlocacaoService;
    }

    @GetMapping
    public ResponseEntity<List<PlanejamentoAlocacao>> listarTodos() {
        List<PlanejamentoAlocacao> lista = planejamentoAlocacaoService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanejamentoAlocacao> listarPorId(@PathVariable Integer id) {
        return planejamentoAlocacaoService.listarPorId(id);
    }

    @PostMapping
    public ResponseEntity<PlanejamentoAlocacao> criar(@RequestBody PlanejamentoAlocacao planejamentoAlocacao) {
        return planejamentoAlocacaoService.salvarOuAtualizar(planejamentoAlocacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanejamentoAlocacao> atualizar(@PathVariable Integer id, @RequestBody PlanejamentoAlocacao planejamentoAlocacao) {
        planejamentoAlocacao.setPlanejamento_alocacao_id(id);
        return planejamentoAlocacaoService.salvarOuAtualizar(planejamentoAlocacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagar(@PathVariable Integer id) {
        return planejamentoAlocacaoService.apagar(id);
    }

    @PatchMapping("/{id}/logico")
    public ResponseEntity<Void> apagarLogicamente(@PathVariable Integer id) {
        return planejamentoAlocacaoService.apagarLogicamente(id);
    }
}
