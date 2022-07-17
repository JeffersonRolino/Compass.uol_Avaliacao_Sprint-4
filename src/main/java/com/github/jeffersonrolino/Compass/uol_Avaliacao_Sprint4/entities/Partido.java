package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.entities;

import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.dtos.PartidoDTO;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.enums.Ideologia;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sigla;
    private Ideologia ideologia;

    @OneToMany(mappedBy = "partido")
    private List<Associado> associados;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataFundacao;

    public Partido(){}

    public Partido(PartidoDTO partidoDTO){
        this.nome = partidoDTO.getNome();
        this.sigla = partidoDTO.getSigla();
        this.ideologia = partidoDTO.getIdeologia();
        this.dataFundacao = partidoDTO.formatarData(partidoDTO.getDataFundacao());
        this.associados = new ArrayList<>();
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

    public List<Associado> getAssociados() {
        return associados;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setIdeologia(Ideologia ideologia) {
        this.ideologia = ideologia;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public void adicionarAssociado(Associado associado) {
        this.associados.add(associado);
    }
}
