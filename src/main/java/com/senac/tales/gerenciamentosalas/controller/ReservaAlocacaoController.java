package com.senac.tales.gerenciamentosalas.controller;

import com.senac.tales.gerenciamentosalas.entity.ReservaAlocacao;
import com.senac.tales.gerenciamentosalas.service.ReservaAlocacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas-alocacao")
public class ReservaAlocacaoController {

    private final ReservaAlocacaoService reservaAlocacaoService;

    public ReservaAlocacaoController(ReservaAlocacaoService reservaAlocacaoService) {
        this.reservaAlocacaoService = reservaAlocacaoService;
    }

    @GetMapping
    public ResponseEntity<List<ReservaAlocacao>> listarTodos() {
        List<ReservaAlocacao> lista = reservaAlocacaoService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaAlocacao> listarPorId(@PathVariable Integer id) {
        return reservaAlocacaoService.listarPorId(id);
    }

    @PostMapping
    public ResponseEntity<ReservaAlocacao> criar(@RequestBody ReservaAlocacao reservaAlocacao) {
        return reservaAlocacaoService.salvarOuAtualizar(reservaAlocacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaAlocacao> atualizar(@PathVariable Integer id, @RequestBody ReservaAlocacao reservaAlocacao) {
        reservaAlocacao.setReserva_alocacao_id(id);
        return reservaAlocacaoService.salvarOuAtualizar(reservaAlocacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagar(@PathVariable Integer id) {
        return reservaAlocacaoService.apagar(id);
    }

    @PatchMapping("/{id}/logico")
    public ResponseEntity<Void> apagarLogicamente(@PathVariable Integer id) {
        return reservaAlocacaoService.apagarLogicamente(id);
    }
}
