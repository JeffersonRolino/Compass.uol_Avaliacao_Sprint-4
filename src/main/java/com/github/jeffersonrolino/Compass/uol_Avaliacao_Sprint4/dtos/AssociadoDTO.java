package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.dtos;

import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.entities.Associado;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.enums.CargoPolitico;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.enums.Sexo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AssociadoDTO {
    private Long id;
    private String nome;
    private CargoPolitico cargoPolitico;
    private String dataNascimento;
    private Sexo sexo;

    public AssociadoDTO(){};

    public AssociadoDTO(Associado associado){
        this.id = associado.getId();
        this.nome = associado.getNome();
        this.cargoPolitico = associado.getCargoPolitico();
        this.dataNascimento = associado.getDataNascimento().toString();
        this.sexo = associado.getSexo();
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }


    public LocalDate formatarData(String data){
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(data, formatador);
    }


}
