package com.senac.tales.gerenciamentosalas.controller;

import com.senac.tales.gerenciamentosalas.entity.Ambiente;
import com.senac.tales.gerenciamentosalas.service.AmbienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ambientes")
public class AmbienteController {

    private final AmbienteService ambienteService;

    public AmbienteController(AmbienteService ambienteService) {
        this.ambienteService = ambienteService;
    }

    @GetMapping
    public ResponseEntity<List<Ambiente>> getAllAmbientes() {
        List<Ambiente> ambientes = ambienteService.getAllAmbientes();
        return ResponseEntity.ok(ambientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ambiente> getAmbienteById(@PathVariable Integer id) {
        Optional<Ambiente> ambiente = ambienteService.getAmbienteById(id);
        return ambiente.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Ambiente> createAmbiente(@RequestBody Ambiente ambiente) {
        Ambiente novoAmbiente = ambienteService.createAmbiente(ambiente);
        return ResponseEntity.ok(novoAmbiente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ambiente> updateAmbiente(@PathVariable Integer id, @RequestBody Ambiente ambiente) {
        try {
            Ambiente ambienteAtualizado = ambienteService.updateAmbiente(id, ambiente);
            return ResponseEntity.ok(ambienteAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAmbiente(@PathVariable Integer id) {
        ambienteService.deleteAmbiente(id);
        return ResponseEntity.noContent().build();
    }
}
