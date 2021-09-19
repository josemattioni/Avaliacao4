package com.example.avaliacao4.services;

import com.example.avaliacao4.dto.AssociadoDTO;
import com.example.avaliacao4.dto.PartidoDTO;
import com.example.avaliacao4.dto.PartidoFormDTO;
import com.example.avaliacao4.entities.CargoPolitico;
import com.example.avaliacao4.entities.Ideologia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PartidoService {

    PartidoDTO save(PartidoFormDTO body);

    Page<PartidoDTO> findAll(Pageable page);

    PartidoDTO search(Long id);

    PartidoDTO update(Long id, PartidoFormDTO body);

    Page<PartidoDTO> findIdeologia(Ideologia ideologia, Pageable page);

    void delete(Long id);
}
