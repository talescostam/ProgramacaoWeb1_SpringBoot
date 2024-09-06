package com.senac.tales.gerenciamentosalas.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usuario_id;

    @Column(length = 300)
    private String usuario_nome;

    @Column(length = 45, unique = true)
    private String usuario_matricula;

    private Integer usuario_tipo;
    private Integer usuario_status;

    @Column(name = "usuario_log_data_criacao")
    private LocalDateTime logDataCriacao;

    @ManyToOne
    @JoinColumn(name = "usuario_lod_responsavel_id")
    private Usuario responsavel;

    public Integer getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getUsuario_nome() {
        return usuario_nome;
    }

    public void setUsuario_nome(String usuario_nome) {
        this.usuario_nome = usuario_nome;
    }

    public String getUsuario_matricula() {
        return usuario_matricula;
    }

    public void setUsuario_matricula(String usuario_matricula) {
        this.usuario_matricula = usuario_matricula;
    }

    public Integer getUsuario_tipo() {
        return usuario_tipo;
    }

    public void setUsuario_tipo(Integer usuario_tipo) {
        this.usuario_tipo = usuario_tipo;
    }

    public Integer getUsuario_status() {
        return usuario_status;
    }

    public void setUsuario_status(Integer usuario_status) {
        this.usuario_status = usuario_status;
    }

    public LocalDateTime getLogDataCriacao() {
        return logDataCriacao;
    }

    public void setLogDataCriacao(LocalDateTime logDataCriacao) {
        this.logDataCriacao = logDataCriacao;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }
}
