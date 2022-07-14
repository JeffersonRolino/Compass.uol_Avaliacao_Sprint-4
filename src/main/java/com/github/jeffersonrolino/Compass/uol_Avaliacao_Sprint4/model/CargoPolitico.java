package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.model;

public enum CargoPolitico {
    VEREADOR("Vereador"),
    PREFEITO("Prefeito"),
    DEPUTADO_ESTADUAL("DeputadoEstadual"),
    DEPUTADO_FEDERAL("DeputadoFederal"),
    SENADOR("Senador"),
    GOVERNADOR("Governador"),
    PRESIDENTE("Presidente");

    private String descricao;

    CargoPolitico(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
