package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.services;

import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.dtos.AssociadoDTO;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.dtos.PartidoDTO;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.entities.Partido;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.enums.Ideologia;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.repositories.AssociadoRepository;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.repositories.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartidoService {
    @Autowired
    private PartidoRepository partidoRepository;

    @Autowired
    private AssociadoRepository associadoRepository;

    public PartidoDTO salvaNovoPartido(PartidoDTO partidoDTO){
        Partido partidoDB = new Partido(partidoDTO);
        Partido partidoSalvo = partidoRepository.save(partidoDB);
        return new PartidoDTO(partidoSalvo);
    }

    public ResponseEntity<PartidoDTO> retornaPartidoPorId(Long id){
        Optional<Partido> partido = partidoRepository.findById(id);
        if(partido.isPresent()){
            return ResponseEntity.ok(new PartidoDTO(partido.get()));
        }
        return ResponseEntity.notFound().build();
    }

    //Atualizar Partido por ID
    public ResponseEntity<PartidoDTO> atualizarPartidoPorId(Long id, PartidoDTO partidoDTO){
        Optional<Partido> partidoAlvo = partidoRepository.findById(id);
        if(partidoAlvo.isPresent()){
            Partido partido = atualizar(id, partidoRepository, partidoDTO);
            partidoRepository.save(partido);
            return ResponseEntity.ok(new PartidoDTO(partido));
        }
        return ResponseEntity.notFound().build();
    }

    //Deletar Partido por ID
    public ResponseEntity<PartidoDTO> deletarPartidoPorId(Long id){
        Optional<Partido> partidoAlvo = partidoRepository.findById(id);
        if(partidoAlvo.isPresent()){
            partidoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


    public Partido atualizar(Long id, PartidoRepository partidoRepository, PartidoDTO partidoDTO){
        Partido partido = partidoRepository.getReferenceById(id);

        partido.setNome(partidoDTO.getNome());
        partido.setSigla(partidoDTO.getSigla());
        partido.setIdeologia(partidoDTO.getIdeologia());
        partido.setDataFundacao((partidoDTO.formatarData(partidoDTO.getDataFundacao())));

        return partido;
    }

    // Usa o Associado Repository por conta do tipo de retorno da entidade <Associado>
    public List<AssociadoDTO> retornaTodosAssociadosDoPartido(Long id) {
        return associadoRepository.findAllByPartido_Id(id).stream().map(AssociadoDTO::new).collect(Collectors.toList());
    }

    public List<PartidoDTO> retornaPorIdeologia(Ideologia ideologia) {
        return partidoRepository.findAllByIdeologia(ideologia).stream().map(PartidoDTO::new).collect(Collectors.toList());
    }

    public List<PartidoDTO> retornaPartidos() {
        return partidoRepository.findAll().stream().map(PartidoDTO::new).collect(Collectors.toList());
    }
}
