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

    public static Ideologia getPelaDescricao(String descricao){
        switch (descricao){
            case "Direita":
                return Ideologia.DIREITA;
            case "Centro":
                return Ideologia.CENTRO;
            case "Esquerda":
                return Ideologia.ESQUERDA;
            default:
                throw new IllegalArgumentException("Descricao " + descricao + "nao suportada.");
        }
    }

}
