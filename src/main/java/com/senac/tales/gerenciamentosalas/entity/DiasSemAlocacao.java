package com.senac.tales.gerenciamentosalas.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class DiasSemAlocacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dias_sem_alocacao_id;

    private LocalDate dias_sem_alocacao_data;
    private Integer dias_sem_alocacao_diaSemana;
    private LocalTime dias_sem_alocacao_horarioInicio;
    private LocalTime dias_sem_alocacao_horarioFim;
    private Integer dias_sem_alocacao_status;

    @ManyToOne
    @JoinColumn(name = "ambiente_id")
    private Ambiente ambiente_id;

    public Integer getDias_sem_alocacao_id() {
        return dias_sem_alocacao_id;
    }

    public void setDias_sem_alocacao_id(Integer dias_sem_alocacao_id) {
        this.dias_sem_alocacao_id = dias_sem_alocacao_id;
    }

    public LocalDate getDias_sem_alocacao_data() {
        return dias_sem_alocacao_data;
    }

    public void setDias_sem_alocacao_data(LocalDate dias_sem_alocacao_data) {
        this.dias_sem_alocacao_data = dias_sem_alocacao_data;
    }

    public Integer getDias_sem_alocacao_diaSemana() {
        return dias_sem_alocacao_diaSemana;
    }

    public void setDias_sem_alocacao_diaSemana(Integer dias_sem_alocacao_diaSemana) {
        this.dias_sem_alocacao_diaSemana = dias_sem_alocacao_diaSemana;
    }

    public LocalTime getDias_sem_alocacao_horarioInicio() {
        return dias_sem_alocacao_horarioInicio;
    }

    public void setDias_sem_alocacao_horarioInicio(LocalTime dias_sem_alocacao_horarioInicio) {
        this.dias_sem_alocacao_horarioInicio = dias_sem_alocacao_horarioInicio;
    }

    public LocalTime getDias_sem_alocacao_horarioFim() {
        return dias_sem_alocacao_horarioFim;
    }

    public void setDias_sem_alocacao_horarioFim(LocalTime dias_sem_alocacao_horarioFim) {
        this.dias_sem_alocacao_horarioFim = dias_sem_alocacao_horarioFim;
    }

    public Integer getDias_sem_alocacao_status() {
        return dias_sem_alocacao_status;
    }

    public void setDias_sem_alocacao_status(Integer dias_sem_alocacao_status) {
        this.dias_sem_alocacao_status = dias_sem_alocacao_status;
    }

    public Ambiente getAmbiente_id() {
        return ambiente_id;
    }

    public void setAmbiente_id(Ambiente ambiente_id) {
        this.ambiente_id = ambiente_id;
    }
}

