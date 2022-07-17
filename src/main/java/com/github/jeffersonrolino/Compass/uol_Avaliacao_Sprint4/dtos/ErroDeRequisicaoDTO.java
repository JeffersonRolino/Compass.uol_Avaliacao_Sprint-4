package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.dtos;

public class ErroDeRequisicaoDTO {
    private String campo;
    private String erro;

    public ErroDeRequisicaoDTO(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
