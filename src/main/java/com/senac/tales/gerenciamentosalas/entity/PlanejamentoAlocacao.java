package com.senac.tales.gerenciamentosalas.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class PlanejamentoAlocacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer planejamento_alocacao_id;

    private LocalDate planejamento_alocacao_data;
    private LocalTime planejamento_alocacao_horaInicio;
    private LocalTime planejamento_alocacao_horaFim;

    @Column(length = 300)
    private String planejamento_alocacao_observacao;

    private Integer planejamento_alocacao_status;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ambiente_id")
    private Ambiente ambiente;

    @ManyToOne
    @JoinColumn(name = "reserva_alocacao_id")
    private ReservaAlocacao reservaAlocacao;

    public Integer getPlanejamento_alocacao_id() {
        return planejamento_alocacao_id;
    }

    public void setPlanejamento_alocacao_id(Integer planejamento_alocacao_id) {
        this.planejamento_alocacao_id = planejamento_alocacao_id;
    }

    public LocalDate getPlanejamento_alocacao_data() {
        return planejamento_alocacao_data;
    }

    public void setPlanejamento_alocacao_data(LocalDate planejamento_alocacao_data) {
        this.planejamento_alocacao_data = planejamento_alocacao_data;
    }

    public LocalTime getPlanejamento_alocacao_horaInicio() {
        return planejamento_alocacao_horaInicio;
    }

    public void setPlanejamento_alocacao_horaInicio(LocalTime planejamento_alocacao_horaInicio) {
        this.planejamento_alocacao_horaInicio = planejamento_alocacao_horaInicio;
    }

    public LocalTime getPlanejamento_alocacao_horaFim() {
        return planejamento_alocacao_horaFim;
    }

    public void setPlanejamento_alocacao_horaFim(LocalTime planejamento_alocacao_horaFim) {
        this.planejamento_alocacao_horaFim = planejamento_alocacao_horaFim;
    }

    public String getPlanejamento_alocacao_observacao() {
        return planejamento_alocacao_observacao;
    }

    public void setPlanejamento_alocacao_observacao(String planejamento_alocacao_observacao) {
        this.planejamento_alocacao_observacao = planejamento_alocacao_observacao;
    }

    public Integer getPlanejamento_alocacao_status() {
        return planejamento_alocacao_status;
    }

    public void setPlanejamento_alocacao_status(Integer planejamento_alocacao_status) {
        this.planejamento_alocacao_status = planejamento_alocacao_status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }

    public ReservaAlocacao getReservaAlocacao() {
        return reservaAlocacao;
    }

    public void setReservaAlocacao(ReservaAlocacao reservaAlocacao) {
        this.reservaAlocacao = reservaAlocacao;
    }
}

