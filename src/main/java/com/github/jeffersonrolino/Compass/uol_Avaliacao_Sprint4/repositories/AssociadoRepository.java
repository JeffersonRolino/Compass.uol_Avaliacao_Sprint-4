package com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.repositories;

import com.github.jeffersonrolino.Compass.uol_Avaliacao_Sprint4.entities.Associado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long > {

//    @Query(value = "select a from Associado a WHERE a.cargoPolitico = :cargoPolitico")
//    List<Associado> retornaPorCargoPolitico(String cargoPolitico);

//    List<Associado> findByCargoPolitico(String cargoPolitico);
}
