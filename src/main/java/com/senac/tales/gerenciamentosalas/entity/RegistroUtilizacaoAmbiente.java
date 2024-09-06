package com.senac.tales.gerenciamentosalas.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class RegistroUtilizacaoAmbiente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer registro_utilizacao_ambiente_id;

    private LocalDateTime registro_utilizacao_ambiente_horaEntrada;
    private LocalDateTime registro_utilizacao_ambiente_horaSaida;
    private Integer registro_utilizacao_ambiente_status;

    @Column(length = 100)
    private String registro_utilizacao_ambiente_observacao;

    @ManyToOne
    @JoinColumn(name = "planejamento_alocacao_id")
    private PlanejamentoAlocacao planejamentoAlocacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id_retirada")
    private Usuario usuarioRetirada;

    @ManyToOne
    @JoinColumn(name = "usuario_id_devolucao")
    private Usuario usuarioDevolucao;

    @ManyToOne
    @JoinColumn(name = "ambiente_id")
    private Ambiente ambiente;

    public Integer getRegistro_utilizacao_ambiente_id() {
        return registro_utilizacao_ambiente_id;
    }

    public void setRegistro_utilizacao_ambiente_id(Integer registro_utilizacao_ambiente_id) {
        this.registro_utilizacao_ambiente_id = registro_utilizacao_ambiente_id;
    }

    public LocalDateTime getRegistro_utilizacao_ambiente_horaEntrada() {
        return registro_utilizacao_ambiente_horaEntrada;
    }

    public void setRegistro_utilizacao_ambiente_horaEntrada(LocalDateTime registro_utilizacao_ambiente_horaEntrada) {
        this.registro_utilizacao_ambiente_horaEntrada = registro_utilizacao_ambiente_horaEntrada;
    }

    public LocalDateTime getRegistro_utilizacao_ambiente_horaSaida() {
        return registro_utilizacao_ambiente_horaSaida;
    }

    public void setRegistro_utilizacao_ambiente_horaSaida(LocalDateTime registro_utilizacao_ambiente_horaSaida) {
        this.registro_utilizacao_ambiente_horaSaida = registro_utilizacao_ambiente_horaSaida;
    }

    public Integer getRegistro_utilizacao_ambiente_status() {
        return registro_utilizacao_ambiente_status;
    }

    public void setRegistro_utilizacao_ambiente_status(Integer registro_utilizacao_ambiente_status) {
        this.registro_utilizacao_ambiente_status = registro_utilizacao_ambiente_status;
    }

    public String getRegistro_utilizacao_ambiente_observacao() {
        return registro_utilizacao_ambiente_observacao;
    }

    public void setRegistro_utilizacao_ambiente_observacao(String registro_utilizacao_ambiente_observacao) {
        this.registro_utilizacao_ambiente_observacao = registro_utilizacao_ambiente_observacao;
    }

    public PlanejamentoAlocacao getPlanejamentoAlocacao() {
        return planejamentoAlocacao;
    }

    public void setPlanejamentoAlocacao(PlanejamentoAlocacao planejamentoAlocacao) {
        this.planejamentoAlocacao = planejamentoAlocacao;
    }

    public Usuario getUsuarioRetirada() {
        return usuarioRetirada;
    }

    public void setUsuarioRetirada(Usuario usuarioRetirada) {
        this.usuarioRetirada = usuarioRetirada;
    }

    public Usuario getUsuarioDevolucao() {
        return usuarioDevolucao;
    }

    public void setUsuarioDevolucao(Usuario usuarioDevolucao) {
        this.usuarioDevolucao = usuarioDevolucao;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }
}

