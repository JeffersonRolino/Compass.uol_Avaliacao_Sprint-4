package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.services;

import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.dtos.AssociadoDTO;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.dtos.PartidoDTO;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.entities.Associado;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.repositories.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssociadoService {
    @Autowired
    private AssociadoRepository associadoRepository;

    public AssociadoDTO salvaNovoAssociado(AssociadoDTO associadoDTO){
        Associado associado = new Associado(associadoDTO);
        associadoRepository.save(associado);
        return new AssociadoDTO(associado);
    }

    public ResponseEntity<AssociadoDTO> retornaAssociadoPorId(Long id){
        Optional<Associado> associado = associadoRepository.findById(id);
        if(associado.isPresent()){
            return ResponseEntity.ok(new AssociadoDTO(associado.get()));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<AssociadoDTO> atualizarAssociadoPorId(Long id, AssociadoDTO associadoDTO){
        Optional<Associado> associadoAlvo = associadoRepository.findById(id);
        if(associadoAlvo.isPresent()){
            Associado associado = atualizarAssociado(id, associadoRepository, associadoDTO);
            associadoRepository.save(associado);
            return ResponseEntity.ok(new AssociadoDTO(associado));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<AssociadoDTO> deletarAssociadoPorId(Long id){
        Optional<Associado> associadoAlvo = associadoRepository.findById(id);
        if(associadoAlvo.isPresent()){
            associadoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    public Associado atualizarAssociado(Long id, AssociadoRepository associadoRepository, AssociadoDTO associadoDTO){
        Associado associado = associadoRepository.getReferenceById(id);

        associado.setNome(associadoDTO.getNome());
        associado.setCargoPolitico(associadoDTO.getCargoPolitico());
        associado.setDataNascimento(associadoDTO.formatarData(associadoDTO.getDataNascimento()));
        associado.setSexo(associadoDTO.getSexo());

        return associado;
    }

}
