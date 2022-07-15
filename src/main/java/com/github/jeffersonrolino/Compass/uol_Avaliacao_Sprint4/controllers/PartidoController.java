package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.controllers;


import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.dtos.PartidoDTO;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.services.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @PostMapping
    public ResponseEntity<PartidoDTO> salvarNovoPartido(@RequestBody PartidoDTO partido, UriComponentsBuilder uriComponentsBuilder){
        PartidoDTO partidoDTO = partidoService.salvaNovoPartido(partido);
        URI uri = uriComponentsBuilder.path("/partidos/{id}").buildAndExpand(partido.getId()).toUri();
        return ResponseEntity.created(uri).body(partidoDTO);
    }
}
