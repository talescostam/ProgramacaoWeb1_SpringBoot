package com.senac.tales.gerenciamentosalas.service;

import com.senac.tales.gerenciamentosalas.entity.Ambiente;
import com.senac.tales.gerenciamentosalas.repository.AmbienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AmbienteService {

    @Autowired
    private AmbienteRepository ambienteRepository;

    public List<Ambiente> getAllAmbientes() {
        return ambienteRepository.findAll();
    }

    public Optional<Ambiente> getAmbienteById(Integer id) {
        return ambienteRepository.findById(id);
    }

    public Ambiente createAmbiente(Ambiente ambiente) {
        return ambienteRepository.save(ambiente);
    }

    public Ambiente updateAmbiente(Integer id, Ambiente ambiente) {
        Optional<Ambiente> existingAmbiente = ambienteRepository.findById(id);
        if (existingAmbiente.isPresent()) {
            ambiente.setAmbiente_id(id);
            return ambienteRepository.save(ambiente);
        } else {
            throw new RuntimeException("Ambiente not found with id " + id);
        }
    }

    public void deleteAmbiente(Integer id) {
        ambienteRepository.deleteById(id);
    }
}

