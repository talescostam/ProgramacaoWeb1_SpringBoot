package com.senac.tales.gerenciamentosalas.service;

import com.senac.tales.gerenciamentosalas.entity.PlanejamentoAlocacao;
import com.senac.tales.gerenciamentosalas.repository.PlanejamentoAlocacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanejamentoAlocacaoService {

    private final PlanejamentoAlocacaoRepository planejamentoAlocacaoRepository;

    public PlanejamentoAlocacaoService(PlanejamentoAlocacaoRepository planejamentoAlocacaoRepository) {
        this.planejamentoAlocacaoRepository = planejamentoAlocacaoRepository;
    }

    public List<PlanejamentoAlocacao> listarTodos() {
        return planejamentoAlocacaoRepository.findAll();
    }

    public ResponseEntity<PlanejamentoAlocacao> listarPorId(Integer id) {
        Optional<PlanejamentoAlocacao> planejamentoAlocacao = planejamentoAlocacaoRepository.findById(id);
        return planejamentoAlocacao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<PlanejamentoAlocacao> salvarOuAtualizar(PlanejamentoAlocacao planejamentoAlocacao) {
        PlanejamentoAlocacao salvo = planejamentoAlocacaoRepository.save(planejamentoAlocacao);
        return new ResponseEntity<>(salvo, HttpStatus.CREATED);
    }

    public ResponseEntity<Void> apagar(Integer id) {
        if (planejamentoAlocacaoRepository.existsById(id)) {
            planejamentoAlocacaoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> apagarLogicamente(Integer id) {
        Optional<PlanejamentoAlocacao> planejamentoAlocacao = planejamentoAlocacaoRepository.findById(id);
        if (planejamentoAlocacao.isPresent()) {
            PlanejamentoAlocacao atual = planejamentoAlocacao.get();
            atual.setPlanejamento_alocacao_status(0);
            planejamentoAlocacaoRepository.save(atual);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
