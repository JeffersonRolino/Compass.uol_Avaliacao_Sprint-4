package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.converters;

import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.enums.Sexo;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class SexoConverter implements AttributeConverter<Sexo, String> {

    @Override
    public String convertToDatabaseColumn(Sexo sexo) {
        return sexo.toString();
    }

    @Override
    public Sexo convertToEntityAttribute(String descricao) {
        return Sexo.getPelaDescricao(descricao);
    }
}
