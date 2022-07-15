package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.enums;

public enum Ideologia {
    DIREITA("Direita"),
    CENTRO("Centro"),
    ESQUERDA("Esquerda");

    private final String descricao;

    Ideologia(String descricao){
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
