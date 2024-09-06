package com.senac.tales.gerenciamentosalas.entity;

import jakarta.persistence.*;

@Entity
public class Ambiente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ambiente_id;

    @Column(length = 15)
    private String ambiente_descricao;

    @Column(name = "ambiente_andar", length = 15)
    private Integer ambiente_andar;

    @Column(length = 15)
    private String ambiente_tipo;

    private Integer ambiente_numeroPcs;
    private Integer ambiente_capacidade;
    private Integer ambiente_status;

    public Integer getAmbiente_id() {
        return ambiente_id;
    }

    public void setAmbiente_id(Integer ambiente_id) {
        this.ambiente_id = ambiente_id;
    }

    public String getAmbiente_descricao() {
        return ambiente_descricao;
    }

    public void setAmbiente_descricao(String ambiente_descricao) {
        this.ambiente_descricao = ambiente_descricao;
    }

    public Integer getAmbiente_andar() {
        return ambiente_andar;
    }

    public void setAmbiente_andar(Integer ambiente_andar) {
        this.ambiente_andar = ambiente_andar;
    }

    public String getAmbiente_tipo() {
        return ambiente_tipo;
    }

    public void setAmbiente_tipo(String ambiente_tipo) {
        this.ambiente_tipo = ambiente_tipo;
    }

    public Integer getAmbiente_numeroPcs() {
        return ambiente_numeroPcs;
    }

    public void setAmbiente_numeroPcs(Integer ambiente_numeroPcs) {
        this.ambiente_numeroPcs = ambiente_numeroPcs;
    }

    public Integer getAmbiente_capacidade() {
        return ambiente_capacidade;
    }

    public void setAmbiente_capacidade(Integer ambiente_capacidade) {
        this.ambiente_capacidade = ambiente_capacidade;
    }

    public Integer getAmbiente_status() {
        return ambiente_status;
    }

    public void setAmbiente_status(Integer ambiente_status) {
        this.ambiente_status = ambiente_status;
    }
}

