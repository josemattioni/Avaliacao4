package com.example.avaliacao4.dto;

import com.example.avaliacao4.entities.Ideologia;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class PartidoDTO {

    private Long id;
    private String nome;
    private String sigla;
    private Ideologia ideologia;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFundacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Ideologia getIdeologia() {
        return ideologia;
    }

    public void setIdeologia(Ideologia ideologia) {
        this.ideologia = ideologia;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
}
