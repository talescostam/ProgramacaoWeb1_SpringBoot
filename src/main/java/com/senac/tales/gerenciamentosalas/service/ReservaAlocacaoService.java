package com.senac.tales.gerenciamentosalas.service;

import com.senac.tales.gerenciamentosalas.entity.ReservaAlocacao;
import com.senac.tales.gerenciamentosalas.repository.ReservaAlocacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaAlocacaoService {

    private final ReservaAlocacaoRepository reservaAlocacaoRepository;

    public ReservaAlocacaoService(ReservaAlocacaoRepository reservaAlocacaoRepository) {
        this.reservaAlocacaoRepository = reservaAlocacaoRepository;
    }

    public List<ReservaAlocacao> listarTodos() {
        return reservaAlocacaoRepository.findAll();
    }

    public ResponseEntity<ReservaAlocacao> listarPorId(Integer id) {
        Optional<ReservaAlocacao> reserva = reservaAlocacaoRepository.findById(id);
        return reserva.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<ReservaAlocacao> salvarOuAtualizar(ReservaAlocacao reservaAlocacao) {
        ReservaAlocacao salvo = reservaAlocacaoRepository.save(reservaAlocacao);
        return new ResponseEntity<>(salvo, HttpStatus.CREATED);
    }

    public ResponseEntity<Void> apagar(Integer id) {
        if (reservaAlocacaoRepository.existsById(id)) {
            reservaAlocacaoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> apagarLogicamente(Integer id) {
        Optional<ReservaAlocacao> reserva = reservaAlocacaoRepository.findById(id);
        if (reserva.isPresent()) {
            ReservaAlocacao atual = reserva.get();
            atual.setReserva_alocacao_status(0);
            reservaAlocacaoRepository.save(atual);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
