package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.services;

import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.dtos.AssociadoDTO;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.entities.Associado;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.repositories.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociadoService {
    @Autowired
    private AssociadoRepository associadoRepository;

    public AssociadoDTO salvaNovoAssociado(AssociadoDTO associadoDTO){
        Associado associado = new Associado(associadoDTO);
        associadoRepository.save(associado);
        return new AssociadoDTO(associado);
    }
}
