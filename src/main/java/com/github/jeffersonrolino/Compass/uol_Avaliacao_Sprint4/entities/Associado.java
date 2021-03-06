package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.entities;

import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.dtos.AssociadoDTO;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.enums.CargoPolitico;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.enums.Sexo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Associado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private CargoPolitico cargoPolitico;

    private LocalDate dataNascimento;

    private Sexo sexo;

    @ManyToOne
    @JoinColumn(name = "partido_id")
    private Partido partido;

    public Associado() {
    }


    public Associado(String nome, CargoPolitico cargoPolitico, LocalDate dataNascimento, Sexo sexo) {
        this.nome = nome;
        this.cargoPolitico = cargoPolitico;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
    }

    public Associado(Long id, String nome, CargoPolitico cargoPolitico, LocalDate dataNascimento, Sexo sexo) {
        this.id = id;
        this.nome = nome;
        this.cargoPolitico = cargoPolitico;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
    }

    public Associado(AssociadoDTO associadoDTO) {
        this.nome = associadoDTO.getNome();
        this.cargoPolitico = associadoDTO.getCargoPolitico();
        this.dataNascimento = associadoDTO.formatarData(associadoDTO.getDataNascimento());
        this.sexo = associadoDTO.getSexo();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public CargoPolitico getCargoPolitico() {
        return cargoPolitico;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargoPolitico(CargoPolitico cargoPolitico) {
        this.cargoPolitico = cargoPolitico;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
}
