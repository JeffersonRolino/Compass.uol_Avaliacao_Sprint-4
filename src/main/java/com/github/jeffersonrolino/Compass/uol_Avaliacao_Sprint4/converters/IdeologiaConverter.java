package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.converters;

import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.enums.Ideologia;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@Converter(autoApply = true)
public class IdeologiaConverter implements AttributeConverter<Ideologia, String> {
    Logger log = LogManager.getLogManager().getLogger(this.getClass().getName());

    @Override
    public String convertToDatabaseColumn(Ideologia ideologia) {
        return ideologia.toString();
    }

    @Override
    public Ideologia convertToEntityAttribute(String descricao) {
        return Ideologia.getPelaDescricao(descricao);
    }
}
