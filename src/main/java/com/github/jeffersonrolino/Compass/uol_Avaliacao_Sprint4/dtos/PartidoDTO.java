package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.dtos;

import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.entities.Partido;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.enums.Ideologia;

import java.time.LocalDate;

public class PartidoDTO {
    private Long id;
    private String nome;
    private String sigla;
    private Ideologia ideologia;
    private LocalDate dataFundacao;

    public PartidoDTO(){}

    public PartidoDTO(Partido partido) {
        this.id = partido.getId();
        this.nome = partido.getNome();
        this.sigla = partido.getSigla();
        this.ideologia = partido.getIdeologia();
        this.dataFundacao = partido.getDataFundacao();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    public Ideologia getIdeologia() {
        return ideologia;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

}
