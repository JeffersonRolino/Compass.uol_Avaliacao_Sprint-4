package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.services;

import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.dtos.PartidoDTO;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.entities.Partido;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.repositories.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartidoService {
    @Autowired
    private PartidoRepository partidoRepository;

    public PartidoDTO salvaNovoPartido(PartidoDTO partidoDTO){
        Partido partidoDB = new Partido(partidoDTO);

        PartidoDTO testeString = new PartidoDTO(partidoDB);
        System.out.println(testeString.formatarData("16/02/2018"));
        System.out.println(testeString.formatarData("16/02/2018").getClass().getSimpleName());

        Partido partidoSalvo = partidoRepository.save(partidoDB);
        return new PartidoDTO(partidoSalvo);
    }
}
