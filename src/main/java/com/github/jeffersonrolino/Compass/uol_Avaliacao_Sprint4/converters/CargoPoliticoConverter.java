package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.converters;

import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.enums.CargoPolitico;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class CargoPoliticoConverter implements AttributeConverter<CargoPolitico, String> {

    @Override
    public String convertToDatabaseColumn(CargoPolitico cargoPolitico) {
        return cargoPolitico.toString();
    }

    @Override
    public CargoPolitico convertToEntityAttribute(String descricao) {
        return CargoPolitico.getPelaDescricao(descricao);
    }
}
