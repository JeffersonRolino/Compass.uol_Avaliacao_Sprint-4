package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.dtos;

import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.entities.Associado;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.entities.Partido;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.enums.Ideologia;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PartidoDTO {
    private Long id;
    private String nome;
    private String sigla;
    private Ideologia ideologia;
    private String dataFundacao;

    public PartidoDTO(){}

    public PartidoDTO(Partido partido) {
        this.id = partido.getId();
        this.nome = partido.getNome();
        this.sigla = partido.getSigla();
        this.ideologia = partido.getIdeologia();
        this.dataFundacao = partido.getDataFundacao().toString();
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

    public String getDataFundacao() {
        return dataFundacao;
    }


    public LocalDate formatarData(String data){
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(data, formatador);
    }



}
