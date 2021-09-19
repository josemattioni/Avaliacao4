package com.example.avaliacao4.repository;

import com.example.avaliacao4.entities.Associado;
import com.example.avaliacao4.entities.CargoPolitico;
import com.example.avaliacao4.entities.Partido;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {
    Page<Associado> findByCargoPolitico(CargoPolitico cargoPolitico, Pageable paginacao);

}
