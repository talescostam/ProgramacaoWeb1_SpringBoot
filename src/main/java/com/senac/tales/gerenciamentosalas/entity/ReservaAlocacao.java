package com.senac.tales.gerenciamentosalas.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class ReservaAlocacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reserva_alocacao_id;

    @Column(length = 300)
    private String reserva_alocacao_justificativa;

    private LocalDate reserva_alocacao_data;
    private LocalTime reserva_alocacao_horaInicio;
    private LocalTime reserva_alocacao_horaFim;
    private Integer reserva_alocacao_status;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Integer getReserva_alocacao_id() {
        return reserva_alocacao_id;
    }

    public void setReserva_alocacao_id(Integer reserva_alocacao_id) {
        this.reserva_alocacao_id = reserva_alocacao_id;
    }

    public String getReserva_alocacao_justificativa() {
        return reserva_alocacao_justificativa;
    }

    public void setReserva_alocacao_justificativa(String reserva_alocacao_justificativa) {
        this.reserva_alocacao_justificativa = reserva_alocacao_justificativa;
    }

    public LocalDate getReserva_alocacao_data() {
        return reserva_alocacao_data;
    }

    public void setReserva_alocacao_data(LocalDate reserva_alocacao_data) {
        this.reserva_alocacao_data = reserva_alocacao_data;
    }

    public LocalTime getReserva_alocacao_horaInicio() {
        return reserva_alocacao_horaInicio;
    }

    public void setReserva_alocacao_horaInicio(LocalTime reserva_alocacao_horaInicio) {
        this.reserva_alocacao_horaInicio = reserva_alocacao_horaInicio;
    }

    public LocalTime getReserva_alocacao_horaFim() {
        return reserva_alocacao_horaFim;
    }

    public void setReserva_alocacao_horaFim(LocalTime reserva_alocacao_horaFim) {
        this.reserva_alocacao_horaFim = reserva_alocacao_horaFim;
    }

    public Integer getReserva_alocacao_status() {
        return reserva_alocacao_status;
    }

    public void setReserva_alocacao_status(Integer reserva_alocacao_status) {
        this.reserva_alocacao_status = reserva_alocacao_status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

