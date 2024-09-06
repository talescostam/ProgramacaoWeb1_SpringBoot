package com.senac.tales.gerenciamentosalas.service;

import com.senac.tales.gerenciamentosalas.entity.DiasSemAlocacao;
import com.senac.tales.gerenciamentosalas.repository.DiasSemAlocacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiasSemAlocacaoService {

    private final DiasSemAlocacaoRepository diasSemAlocacaoRepository;

    public DiasSemAlocacaoService(DiasSemAlocacaoRepository diasSemAlocacaoRepository) {
        this.diasSemAlocacaoRepository = diasSemAlocacaoRepository;
    }

    public List<DiasSemAlocacao> getAllDiasSemAlocacao() {
        return diasSemAlocacaoRepository.findAll();
    }

    public Optional<DiasSemAlocacao> getDiasSemAlocacaoById(Integer id) {
        return diasSemAlocacaoRepository.findById(id);
    }

    public DiasSemAlocacao createDiasSemAlocacao(DiasSemAlocacao diasSemAlocacao) {
        return diasSemAlocacaoRepository.save(diasSemAlocacao);
    }

    public DiasSemAlocacao updateDiasSemAlocacao(Integer id, DiasSemAlocacao diasSemAlocacao) {
        if (diasSemAlocacaoRepository.existsById(id)) {
            diasSemAlocacao.setDias_sem_alocacao_id(id);
            return diasSemAlocacaoRepository.save(diasSemAlocacao);
        } else {
            throw new RuntimeException("DiaSemAlocacao não encontrado");
        }
    }

    public void deleteDiasSemAlocacao(Integer id) {
        diasSemAlocacaoRepository.deleteById(id);
    }
}
