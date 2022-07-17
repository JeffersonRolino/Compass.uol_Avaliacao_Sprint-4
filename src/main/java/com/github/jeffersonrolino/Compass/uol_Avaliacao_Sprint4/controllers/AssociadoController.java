package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.controllers;

import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.dtos.AssociadoDTO;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.dtos.AssociadoPartidoDTO;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.services.AssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/associados")
public class AssociadoController {

    @Autowired
    AssociadoService associadoService;

    @PostMapping
    public ResponseEntity<AssociadoDTO> salvarNovoAssociado(@RequestBody AssociadoDTO associado, UriComponentsBuilder uriComponentsBuilder){
        AssociadoDTO associadoDTO = associadoService.salvaNovoAssociado(associado);
        URI uri = uriComponentsBuilder.path("/associados/{id}").buildAndExpand(associado.getId()).toUri();
        return ResponseEntity.created(uri).body(associadoDTO);
    }

    @PostMapping("/partidos")
    public ResponseEntity<AssociadoDTO> vincularAssociadoAPartido(@RequestBody AssociadoPartidoDTO associadoPartidoDTO, UriComponentsBuilder uriComponentsBuilder){
        return associadoService.vincularAssociadoAPartido(associadoPartidoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssociadoDTO> retornarAssociadoPorId(@PathVariable() Long id){
        return associadoService.retornaAssociadoPorId(id);
    }

    @PutMapping("/{id}") @Modifying(clearAutomatically = true)
    public ResponseEntity<AssociadoDTO> atualizarAssociadoPorId(@PathVariable() Long id, @RequestBody AssociadoDTO associadoDTO){
        return associadoService.atualizarAssociadoPorId(id, associadoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AssociadoDTO> deletarAssociadoPorId(@PathVariable Long id){
        return associadoService.deletarAssociadoPorId(id);
    }

}
