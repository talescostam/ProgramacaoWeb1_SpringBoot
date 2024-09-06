package com.senac.tales.gerenciamentosalas.service;

import com.senac.tales.gerenciamentosalas.entity.RegistroUtilizacaoAmbiente;
import com.senac.tales.gerenciamentosalas.repository.RegistroUtilizacaoAmbienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroUtilizacaoAmbienteService {

    private final RegistroUtilizacaoAmbienteRepository registroUtilizacaoAmbienteRepository;

    public RegistroUtilizacaoAmbienteService(RegistroUtilizacaoAmbienteRepository registroUtilizacaoAmbienteRepository) {
        this.registroUtilizacaoAmbienteRepository = registroUtilizacaoAmbienteRepository;
    }

    public List<RegistroUtilizacaoAmbiente> listarTodos() {
        return registroUtilizacaoAmbienteRepository.findAll();
    }

    public ResponseEntity<RegistroUtilizacaoAmbiente> listarPorId(Integer id) {
        Optional<RegistroUtilizacaoAmbiente> registro = registroUtilizacaoAmbienteRepository.findById(id);
        return registro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<RegistroUtilizacaoAmbiente> salvarOuAtualizar(RegistroUtilizacaoAmbiente registroUtilizacaoAmbiente) {
        RegistroUtilizacaoAmbiente salvo = registroUtilizacaoAmbienteRepository.save(registroUtilizacaoAmbiente);
        return new ResponseEntity<>(salvo, HttpStatus.CREATED);
    }

    public ResponseEntity<Void> apagar(Integer id) {
        if (registroUtilizacaoAmbienteRepository.existsById(id)) {
            registroUtilizacaoAmbienteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> apagarLogicamente(Integer id) {
        Optional<RegistroUtilizacaoAmbiente> registro = registroUtilizacaoAmbienteRepository.findById(id);
        if (registro.isPresent()) {
            RegistroUtilizacaoAmbiente atual = registro.get();
            atual.setRegistro_utilizacao_ambiente_status(0);
            registroUtilizacaoAmbienteRepository.save(atual);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
