package com.example.avaliacao4.repository;

import com.example.avaliacao4.entities.Associado;
import com.example.avaliacao4.entities.CargoPolitico;
import com.example.avaliacao4.entities.Ideologia;
import com.example.avaliacao4.entities.Partido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidoRepository extends JpaRepository<Partido, Long> {

    Page<Partido> findByIdeologia(Ideologia ideologia, Pageable paginacao);
}
