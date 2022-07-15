package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.dtos;

import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.entities.Associado;

import java.time.LocalDate;

public class AssociadoDTO {
    private Long id;
    private String nome;
    private String cargoPolitico;
    private LocalDate dataNascimento;
    private String sexo;

    public AssociadoDTO(){};

    public AssociadoDTO(Associado associado){
        this.id = associado.getId();
        this.nome = associado.getNome();
        this.cargoPolitico = associado.getCargoPolitico().toString();
        this.dataNascimento = associado.getDataNascimento();
        this.sexo = associado.getSexo().toString();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCargoPolitico() {
        return cargoPolitico;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargoPolitico(String cargoPolitico) {
        this.cargoPolitico = cargoPolitico;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
