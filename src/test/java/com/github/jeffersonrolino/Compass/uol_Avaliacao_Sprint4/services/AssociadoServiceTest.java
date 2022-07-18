package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.services;

import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.dtos.AssociadoDTO;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.entities.Associado;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.enums.CargoPolitico;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.enums.Sexo;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.repositories.AssociadoRepository;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.repositories.PartidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AssociadoServiceTest {

    @Mock
    private PartidoRepository partidoRepository;

    @Mock
    private AssociadoRepository associadoRepository;

    @Mock
    private AssociadoService associadoService;

    @BeforeEach
    void preparar() {
        associadoService = new AssociadoService(associadoRepository, partidoRepository);
    }

    @Test
    @Disabled
    void salvaNovoAssociado() {
    }

    @Test
    void retornaAssociadosPorCargoPolitico() {
        Associado associado = new Associado("Pedro", CargoPolitico.SENADOR, LocalDate.now(), Sexo.MASCULINO);

        associadoService.retornaAssociadosPorCargoPolitico(associado.getCargoPolitico());

        verify(associadoRepository).findAllByCargoPolitico(associado.getCargoPolitico());
    }

    @Test
    @Disabled
    void retornaAssociados() {
    }

    @Test
    void retornaAssociadoPorId() {
        Associado associado = new Associado(1L, "Pedro", CargoPolitico.SENADOR, LocalDate.now(), Sexo.MASCULINO);
        associadoService.retornaAssociadoPorId(associado.getId());
        verify(associadoRepository).findById(associado.getId());
    }

    @Test
    void atualizarAssociadoPorId() {
        Associado associado = new Associado(1L, "Pedro", CargoPolitico.SENADOR, LocalDate.now(), Sexo.MASCULINO);
        AssociadoDTO associadoDTO = new AssociadoDTO(associado);
        associadoService.atualizarAssociadoPorId(associado.getId(), associadoDTO);
        verify(associadoRepository).findById(associado.getId());
    }

    @Test
    @Disabled
    void vincularAssociadoAPartido() {
    }

    @Test
    @Disabled
    void desvincularAssociadoAPartido() {
    }

    @Test
    @Disabled
    void deletarAssociadoPorId() {
    }

    @Test
    @Disabled
    void atualizarAssociado() {
    }

    @Test
    @Disabled
    void vincularAssociado() {
    }

    @Test
    @Disabled
    void desvincularAssociado() {
    }

    @Test
    @Disabled
    void retornaAssociadosOrdenadosPorNome() {
    }
}