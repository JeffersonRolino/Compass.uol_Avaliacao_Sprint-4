package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.repositories;

import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.entities.Associado;
import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.enums.CargoPolitico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long > {

    List<Associado> findAllByCargoPolitico(CargoPolitico cargoPolitico);

    List<Associado> findAllByPartido_Id(Long id);
}
