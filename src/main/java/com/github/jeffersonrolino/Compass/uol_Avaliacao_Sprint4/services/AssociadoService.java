package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.services;

import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.dtos.AssociadoDTO;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.dtos.AssociadoPartidoDTO;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.entities.Associado;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.entities.Partido;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.enums.CargoPolitico;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.repositories.AssociadoRepository;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.repositories.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssociadoService {
    @Autowired
    private AssociadoRepository associadoRepository;

    @Autowired
    private PartidoRepository partidoRepository;

    public AssociadoService(AssociadoRepository associadoRepository, PartidoRepository partidoRepository) {
        this.associadoRepository = associadoRepository;
        this.partidoRepository = partidoRepository;
    }

    public AssociadoDTO salvaNovoAssociado(AssociadoDTO associadoDTO){
        Associado associado = new Associado(associadoDTO);
        associadoRepository.save(associado);
        return new AssociadoDTO(associado);
    }

    public List<AssociadoDTO> retornaAssociadosPorCargoPolitico(CargoPolitico cargoPolitico) {
        return associadoRepository.findAllByCargoPolitico(cargoPolitico).stream().map(AssociadoDTO::new).collect(Collectors.toList());
    }

    public List<AssociadoDTO> retornaAssociados() {
        return associadoRepository.findAll().stream().map(AssociadoDTO::new).collect(Collectors.toList());
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

    public ResponseEntity<AssociadoDTO> vincularAssociadoAPartido(AssociadoPartidoDTO associadoPartidoDTO){
        Optional<Associado> associadoAlvo = associadoRepository.findById(associadoPartidoDTO.getIdAssociado());
        Optional<Partido> partidoAlvo = partidoRepository.findById(associadoPartidoDTO.getIdPartido());
        if(associadoAlvo.isPresent() && partidoAlvo.isPresent()){
            Associado associado = vincularAssociado(associadoPartidoDTO, associadoRepository, partidoRepository);
            associadoRepository.save(associado);

            return ResponseEntity.ok(new AssociadoDTO(associado));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<AssociadoDTO> desvincularAssociadoAPartido(Long associadoId, Long partidoId){
        Optional<Associado> associadoAlvo = associadoRepository.findById(associadoId);
        Optional<Partido> partidoAlvo = partidoRepository.findById(partidoId);
        if(associadoAlvo.isPresent() && partidoAlvo.isPresent()){
            Associado associado = desvincularAssociado(associadoId);
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

    public Associado vincularAssociado(AssociadoPartidoDTO associadoPartidoDTO, AssociadoRepository associadoRepository, PartidoRepository partidoRepository){
        Associado associado = associadoRepository.getReferenceById(associadoPartidoDTO.getIdAssociado());
        Partido partido = partidoRepository.getReferenceById(associadoPartidoDTO.getIdPartido());

        associado.setPartido(partido);
        partido.adicionarAssociado(associado);

        return associado;
    }

    public Associado desvincularAssociado(Long associadoId){
        Associado associado = associadoRepository.getReferenceById(associadoId);

        associado.setPartido(null);

        return associado;
    }

    public List<AssociadoDTO> retornaAssociadosOrdenadosPorNome() {
        return associadoRepository.findAll(Sort.by(Sort.Direction.ASC, "nome")).stream().map(AssociadoDTO::new).collect(Collectors.toList());
    }
}
