package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.services;

import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.dtos.AssociadoDTO;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.dtos.PartidoDTO;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.entities.Associado;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.entities.Partido;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.enums.CargoPolitico;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.enums.Ideologia;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.enums.Sexo;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.repositories.AssociadoRepository;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.repositories.PartidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PartidoServiceTest {

    @Mock
    private PartidoRepository partidoRepository;

    @Mock
    private AssociadoRepository associadoRepository;

    @Mock
    private PartidoService partidoService;

    @BeforeEach
    void preparar(){
        partidoService = new PartidoService(partidoRepository, associadoRepository);
    }

    @Test
    void salvaNovoPartido() {
        //Dado
        PartidoDTO partidoDTO = new PartidoDTO("PartidoA", "PA", Ideologia.ESQUERDA, "15/07/2022");

        boolean salvo = partidoService.salvaNovoPartido(partidoDTO);

        //Quando
        ArgumentCaptor<Partido> partidoArgumentCaptor = ArgumentCaptor.forClass(Partido.class);

        verify(partidoRepository).save(partidoArgumentCaptor.capture());

        Partido capturePartido = partidoArgumentCaptor.getValue();

        String classe = capturePartido.getClass().getSimpleName();

        //Então
        assertThat(capturePartido).isNotNull();
        assertThat(classe).isEqualTo(Partido.class.getSimpleName());
        assertThat(salvo).isEqualTo(true);
    }

    @Test
    void retornaPartidoPorId() {
        Partido partido = new Partido("PartidoA", "PA", Ideologia.ESQUERDA, LocalDate.now());

        partidoService.retornaPartidoPorId(partido.getId());

        verify(partidoRepository).findById(partido.getId());
    }

    @Test
    @Disabled
    void atualizarPartidoPorId() {
        Partido partido = new Partido(1L, "PartidoA", "PA", Ideologia.ESQUERDA, LocalDate.now());
        PartidoDTO partidoDTO = new PartidoDTO("PartidoB", "PA", Ideologia.ESQUERDA, "15/07/2022");

        partidoService.atualizarPartidoPorId(partido.getId(), partidoDTO);

        ArgumentCaptor<Partido> partidoArgumentCaptor = ArgumentCaptor.forClass(Partido.class);

        verify(partidoRepository).save(partidoArgumentCaptor.capture());

        Partido capturePartido = partidoArgumentCaptor.getValue();

        assertThat(capturePartido).isEqualTo(partido);
    }

    @Test
    @Disabled
    void deletarPartidoPorId() {
    }

    @Test
    @Disabled
    void atualizar() {
        //Dado
        Partido partido = new Partido(1L, "PartidoA", "PA", Ideologia.ESQUERDA, LocalDate.now());
        partidoRepository.save(partido);
//        PartidoDTO partidoDTO = new PartidoDTO("PartidoB", "PB", Ideologia.ESQUERDA, "15/07/2022");

//        partidoService.atualizar(0L, partidoRepository, partidoDTO);

        //Quando
        ArgumentCaptor<Partido> partidoArgumentCaptor = ArgumentCaptor.forClass(Partido.class);

        Partido capturePartido = partidoArgumentCaptor.getValue();

        String classe = capturePartido.getClass().getSimpleName();

        //Então
        assertThat(capturePartido).isNotNull();
        assertThat(classe).isEqualTo(Partido.class.getSimpleName());
    }

    @Test
    @Disabled
    void retornaTodosAssociadosDoPartido() {
        //dado
        Partido partidoA = new Partido("Partido A", "PA", Ideologia.ESQUERDA, LocalDate.now());
        Partido partidoB = new Partido("Partido B", "PB", Ideologia.DIREITA, LocalDate.now());

        partidoRepository.save(partidoA);
        partidoRepository.save(partidoB);


        CargoPolitico cargoPolitico = CargoPolitico.VEREADOR;

        Associado associado1 = new Associado("Pedro Pereira", cargoPolitico, LocalDate.now(), Sexo.MASCULINO);
        Associado associado2 = new Associado("Paulo Souza", CargoPolitico.DEPUTADO_ESTADUAL, LocalDate.now(), Sexo.MASCULINO);
        Associado associado3 = new Associado("Kátia Oliveira", CargoPolitico.SENADOR, LocalDate.now(), Sexo.MASCULINO);
        Associado associado4 = new Associado("José Siqueira", cargoPolitico, LocalDate.now(), Sexo.MASCULINO);

        associadoRepository.save(associado1);
        associadoRepository.save(associado2);
        associadoRepository.save(associado3);
        associadoRepository.save(associado4);


        associado1.setPartido(partidoA);
        associado2.setPartido(partidoA);
        associado3.setPartido(partidoB);
        associado4.setPartido(partidoB);


        //Quando
        List<AssociadoDTO> associadosAoPartidoA = partidoService.retornaTodosAssociadosDoPartido(partidoA.getId());

        List<AssociadoDTO> associadosAoPartidoB = partidoService.retornaTodosAssociadosDoPartido(partidoB.getId());


        //Então

        assertThat(associadosAoPartidoA.size()).isEqualTo(2);
        assertThat(associadosAoPartidoA.get(0)).isNotNull();
        assertThat(associadosAoPartidoA.get(0)).isOfAnyClassIn(Associado.class);
        assertThat(associadosAoPartidoA.get(1)).isOfAnyClassIn(Associado.class);

        assertThat(associadosAoPartidoB.size()).isEqualTo(2);
        assertThat(associadosAoPartidoB.get(0)).isNotNull();
        assertThat(associadosAoPartidoB.get(0)).isOfAnyClassIn(Associado.class);
        assertThat(associadosAoPartidoB.get(1)).isOfAnyClassIn(Associado.class);

        System.out.println(associadosAoPartidoA.size());
    }

    @Test
    void retornaPorIdeologia() {
        Partido partido = new Partido("PartidoA", "PA", Ideologia.ESQUERDA, LocalDate.now());

        partidoService.retornaPorIdeologia(partido.getIdeologia());

        verify(partidoRepository).findAllByIdeologia(partido.getIdeologia());
    }

    @Test
    void retornaPartidos() {
        partidoService.retornaPartidos();

        verify(partidoRepository).findAll();
    }
}