package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.controllers;

import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.dtos.AssociadoDTO;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.services.AssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
