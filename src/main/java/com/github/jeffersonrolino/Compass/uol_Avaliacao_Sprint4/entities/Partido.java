package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.entities;

import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.dtos.PartidoDTO;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.enums.Ideologia;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sigla;

    @Enumerated(EnumType.STRING)
    private Ideologia ideologia;
    private LocalDate dataFundacao;

    public Partido(){};

    public Partido(String nome, String sigla, Ideologia ideologia, LocalDate dataFundacao) {
        this.nome = nome;
        this.sigla = sigla;
        this.ideologia = ideologia;
        this.dataFundacao = dataFundacao;
    }

    public Partido(Long id, String nome, String sigla, Ideologia ideologia, LocalDate dataFundacao) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.ideologia = ideologia;
        this.dataFundacao = dataFundacao;
    }

    public Partido(PartidoDTO partidoDTO){
        this.nome = partidoDTO.getNome();
        this.sigla = partidoDTO.getSigla();
        this.ideologia = partidoDTO.getIdeologia();
        this.dataFundacao = partidoDTO.getDataFundacao();
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
