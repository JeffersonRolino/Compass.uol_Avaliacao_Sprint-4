package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.model;

public enum Ideologia {
    DIREITA("Direita"),
    CENTRO("Centro"),
    ESQUERDA("Esquerda");

    private String descricao;

    Ideologia(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
