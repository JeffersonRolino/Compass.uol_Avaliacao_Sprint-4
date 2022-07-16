package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.enums;

public enum Sexo {
    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private final String descricao;

    Sexo(String descricao){
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }

    public static Sexo getPelaDescricao(String descricao){
        switch (descricao){
            case "Masculino":
                return Sexo.MASCULINO;
            case "Feminino":
                return Sexo.FEMININO;
            default:
                throw new IllegalArgumentException("Descricao " + descricao + "nao suportada.");
        }
    }
}
