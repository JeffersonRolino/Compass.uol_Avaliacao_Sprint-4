package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.dtos;

import javax.validation.constraints.NotNull;

public class AssociadoPartidoDTO {

    @NotNull
    private Long idAssociado;

    @NotNull
    private Long idPartido;

    public AssociadoPartidoDTO(Long idAssociado, Long idPartido) {
        this.idAssociado = idAssociado;
        this.idPartido = idPartido;
    }

    public Long getIdAssociado() {
        return idAssociado;
    }

    public void setIdAssociado(Long idAssociado) {
        this.idAssociado = idAssociado;
    }

    public Long getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(Long idPartido) {
        this.idPartido = idPartido;
    }
}
