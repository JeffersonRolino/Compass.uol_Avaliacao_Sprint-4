package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.enums;

public enum CargoPolitico {
    VEREADOR("Vereador"),
    PREFEITO("Prefeito"),
    DEPUTADO_ESTADUAL("DeputadoEstadual"),
    DEPUTADO_FEDERAL("DeputadoFederal"),
    SENADOR("Senador"),
    GOVERNADOR("Governador"),
    PRESIDENTE("Presidente");

    private final String descricao;

    CargoPolitico(String descricao){
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
