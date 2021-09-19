package com.example.avaliacao4.dto;

import com.example.avaliacao4.entities.Associado;
import com.example.avaliacao4.entities.CargoPolitico;
import com.example.avaliacao4.entities.Partido;
import com.example.avaliacao4.entities.Sexo;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;



public class AssociadoDTO {

    private Long id;
    private String nome;
    private CargoPolitico cargoPolitico;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    private Sexo sexo;
    private Partido partido;

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CargoPolitico getCargoPolitico() {
        return cargoPolitico;
    }

    public void setCargoPolitico(CargoPolitico cargoPolitico) {
        this.cargoPolitico = cargoPolitico;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}
