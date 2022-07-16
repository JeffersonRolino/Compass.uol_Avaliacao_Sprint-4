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

    public static CargoPolitico getPelaDescricao(String descricao) {
        switch (descricao){
            case "Vereador":
                return CargoPolitico.VEREADOR;
            case "Prefeito":
                return CargoPolitico.PREFEITO;
            case "DeputadoEstadual":
                return CargoPolitico.DEPUTADO_ESTADUAL;
            case "DeputadoFederal":
                return CargoPolitico.DEPUTADO_FEDERAL;
            case "Senador":
                return CargoPolitico.SENADOR;
            case "Governador":
                return CargoPolitico.GOVERNADOR;
            case "Presidente":
                return CargoPolitico.PRESIDENTE;
            default:
                throw new IllegalArgumentException("Descricao " + descricao + "nao suportada.");
        }
    }
}
