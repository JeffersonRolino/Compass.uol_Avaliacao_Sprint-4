package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.controllers;


import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.dtos.AssociadoDTO;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.dtos.PartidoDTO;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.enums.Ideologia;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.services.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @PostMapping
    public ResponseEntity<PartidoDTO> salvarNovoPartido(@RequestBody @Valid PartidoDTO partido, UriComponentsBuilder uriComponentsBuilder){
        PartidoDTO partidoDTO = partidoService.salvaNovoPartido(partido);
        URI uri = uriComponentsBuilder.path("/partidos/{id}").buildAndExpand(partido.getId()).toUri();
        return ResponseEntity.created(uri).body(partidoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartidoDTO> retornaPartidoPorId(@PathVariable() Long id){
        return partidoService.retornaPartidoPorId(id);
    }

    @GetMapping
    public List<PartidoDTO> retornaPartidos(String ideologia){
        if(ideologia != null){
            Ideologia ideologiaRequest = Ideologia.getPelaDescricao(ideologia);
            return partidoService.retornaPorIdeologia(ideologiaRequest);
        }
        return partidoService.retornaPartidos();
    }

    @GetMapping("/{id}/associados")
    public List<AssociadoDTO> retornaTodosAssociadosDoPartidoPorId(@PathVariable Long id){
        return partidoService.retornaTodosAssociadosDoPartido(id);
    }

    @PutMapping("/{id}") @Modifying(clearAutomatically = true)
    public ResponseEntity<PartidoDTO> atualizarPartidoPorId(@PathVariable() Long id, @RequestBody PartidoDTO partidoDTO){
        return partidoService.atualizarPartidoPorId(id, partidoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PartidoDTO> deletarPartidoPorId(@PathVariable Long id){
        return partidoService.deletarPartidoPorId(id);
    }
}
