package com.senac.tales.gerenciamentosalas.controller;

import com.senac.tales.gerenciamentosalas.entity.DiasSemAlocacao;
import com.senac.tales.gerenciamentosalas.service.DiasSemAlocacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/diasSemAlocacao")
public class DiasSemAlocacaoController {

    private final DiasSemAlocacaoService diasSemAlocacaoService;

    public DiasSemAlocacaoController(DiasSemAlocacaoService diasSemAlocacaoService) {
        this.diasSemAlocacaoService = diasSemAlocacaoService;
    }

    @GetMapping
    public ResponseEntity<List<DiasSemAlocacao>> getAllDiasSemAlocacao() {
        List<DiasSemAlocacao> diasSemAlocacao = diasSemAlocacaoService.getAllDiasSemAlocacao();
        return ResponseEntity.ok(diasSemAlocacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiasSemAlocacao> getDiasSemAlocacaoById(@PathVariable Integer id) {
        Optional<DiasSemAlocacao> diasSemAlocacao = diasSemAlocacaoService.getDiasSemAlocacaoById(id);
        return diasSemAlocacao.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DiasSemAlocacao> createDiasSemAlocacao(@RequestBody DiasSemAlocacao diasSemAlocacao) {
        DiasSemAlocacao novoDiasSemAlocacao = diasSemAlocacaoService.createDiasSemAlocacao(diasSemAlocacao);
        return ResponseEntity.ok(novoDiasSemAlocacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiasSemAlocacao> updateDiasSemAlocacao(@PathVariable Integer id, @RequestBody DiasSemAlocacao diasSemAlocacao) {
        try {
            DiasSemAlocacao atualizado = diasSemAlocacaoService.updateDiasSemAlocacao(id, diasSemAlocacao);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiasSemAlocacao(@PathVariable Integer id) {
        diasSemAlocacaoService.deleteDiasSemAlocacao(id);
        return ResponseEntity.noContent().build();
    }
}
