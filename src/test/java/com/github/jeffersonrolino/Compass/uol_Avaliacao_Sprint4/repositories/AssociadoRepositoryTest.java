package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.repositories;

import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.dtos.AssociadoDTO;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.dtos.AssociadoPartidoDTO;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.entities.Associado;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.entities.Partido;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.enums.CargoPolitico;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.enums.Ideologia;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.enums.Sexo;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.services.AssociadoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class AssociadoRepositoryTest {

    @Autowired
    private AssociadoRepository associadoRepositoryTest;

    @Autowired
    private PartidoRepository partidoRepositoryTest;



    @Test
    public void findAllByCargoPolitico() {
        //dado
        CargoPolitico cargoPolitico = CargoPolitico.GOVERNADOR;

        Associado associado1 = new Associado("Pedro Pereira", cargoPolitico, LocalDate.now(), Sexo.MASCULINO);
        Associado associado2 = new Associado("Paulo Souza", CargoPolitico.DEPUTADO_ESTADUAL, LocalDate.now(), Sexo.MASCULINO);
        Associado associado3 = new Associado("Kátia Oliveira", CargoPolitico.SENADOR, LocalDate.now(), Sexo.MASCULINO);
        Associado associado4 = new Associado("José Siqueira", cargoPolitico, LocalDate.now(), Sexo.MASCULINO);

        associadoRepositoryTest.save(associado1);
        associadoRepositoryTest.save(associado2);
        associadoRepositoryTest.save(associado3);
        associadoRepositoryTest.save(associado4);

        //Quando
        List<Associado> associados = associadoRepositoryTest.findAllByCargoPolitico(cargoPolitico);

        //Então

        assertThat(associados.size()).isEqualTo(2);
        assertThat(associados.get(0)).isNotNull();
        assertThat(associados.get(0)).isOfAnyClassIn(Associado.class);

        associados.forEach(associado -> {
            assertThat(associado.getCargoPolitico()).isEqualTo(cargoPolitico);
        });

    }

    @Test
    public void findAllByPartido_Id() {
        //dado
        Partido partidoA = new Partido("Partido A", "PA", Ideologia.ESQUERDA, LocalDate.now());
        Partido partidoB = new Partido("Partido B", "PB", Ideologia.DIREITA, LocalDate.now());

        partidoRepositoryTest.save(partidoA);
        partidoRepositoryTest.save(partidoB);


        CargoPolitico cargoPolitico = CargoPolitico.VEREADOR;

        Associado associado1 = new Associado("Pedro Pereira", cargoPolitico, LocalDate.now(), Sexo.MASCULINO);
        Associado associado2 = new Associado("Paulo Souza", CargoPolitico.DEPUTADO_ESTADUAL, LocalDate.now(), Sexo.MASCULINO);
        Associado associado3 = new Associado("Kátia Oliveira", CargoPolitico.SENADOR, LocalDate.now(), Sexo.MASCULINO);
        Associado associado4 = new Associado("José Siqueira", cargoPolitico, LocalDate.now(), Sexo.MASCULINO);

        associadoRepositoryTest.save(associado1);
        associadoRepositoryTest.save(associado2);
        associadoRepositoryTest.save(associado3);
        associadoRepositoryTest.save(associado4);


        associado1.setPartido(partidoA);
        associado2.setPartido(partidoA);
        associado3.setPartido(partidoB);
        associado4.setPartido(partidoB);


        //Quando
        List<Associado> associadosAoPartidoA = associadoRepositoryTest.findAllByPartido_Id(partidoA.getId());

        List<Associado> associadosAoPartidoB = associadoRepositoryTest.findAllByPartido_Id(partidoB.getId());


        //Então

        assertThat(associadosAoPartidoA.size()).isEqualTo(2);
        assertThat(associadosAoPartidoA.get(0)).isNotNull();
        assertThat(associadosAoPartidoA.get(0)).isOfAnyClassIn(Associado.class);
        assertThat(associadosAoPartidoA.get(1)).isOfAnyClassIn(Associado.class);

        assertThat(associadosAoPartidoB.size()).isEqualTo(2);
        assertThat(associadosAoPartidoB.get(0)).isNotNull();
        assertThat(associadosAoPartidoB.get(0)).isOfAnyClassIn(Associado.class);
        assertThat(associadosAoPartidoB.get(1)).isOfAnyClassIn(Associado.class);

        associadosAoPartidoA.forEach(associado -> {
            assertThat(associado.getPartido()).isEqualTo(partidoA);
        });

        associadosAoPartidoB.forEach(associado -> {
            assertThat(associado.getPartido()).isEqualTo(partidoB);
        });

    }
}