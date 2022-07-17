package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.repositories;

import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.entities.Partido;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.enums.Ideologia;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PartidoRepositoryTest {

    @Autowired
    private PartidoRepository partidoRepositoryTest;

    @AfterEach
    void deleteTodos(){
        partidoRepositoryTest.deleteAll();
    }

    @Test
    void findAllByIdeologia() {
        //dado
        Ideologia ideologia = Ideologia.ESQUERDA;

        Partido partidoA = new Partido("Partido A", "PA", Ideologia.ESQUERDA, LocalDate.now());
        Partido partidoB = new Partido("Partido B", "PB", Ideologia.DIREITA, LocalDate.now());
        Partido partidoC = new Partido("Partido C", "PC", Ideologia.CENTRO, LocalDate.now());
        Partido partidoD = new Partido("Partido D", "PD", Ideologia.ESQUERDA, LocalDate.now());

        partidoRepositoryTest.save(partidoA);
        partidoRepositoryTest.save(partidoB);
        partidoRepositoryTest.save(partidoC);
        partidoRepositoryTest.save(partidoD);

        //Quando
        List<Partido> partidos = partidoRepositoryTest.findAllByIdeologia(ideologia);

        //Então
        assertThat(partidos.size()).isEqualTo(2);

        partidos.forEach(partido -> {
            assertThat(partido.getIdeologia()).isEqualTo(ideologia);
            assertThat(partido).isNotNull();
            assertThat(partido).isOfAnyClassIn(Partido.class);
        });

    }
}