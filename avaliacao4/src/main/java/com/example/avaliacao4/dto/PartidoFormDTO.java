package com.example.avaliacao4.dto;

import com.example.avaliacao4.entities.Ideologia;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

public class PartidoFormDTO {

    @NotEmpty(message = "nome is required")
    private String nome;
    @NotNull(message = "Sigla is required")
    private String sigla;
    @NotNull(message = "Ideologia is required")
    private Ideologia ideologia;
    @NotNull(message = "Data fundacao is required")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFundacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
