package com.example.avaliacao4.services;

import com.example.avaliacao4.dto.AssociadoDTO;
import com.example.avaliacao4.dto.AssociadoFormDTO;
import com.example.avaliacao4.entities.Associado;
import com.example.avaliacao4.entities.CargoPolitico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AssociadoService {

    AssociadoDTO save(AssociadoFormDTO body);

    Page<AssociadoDTO> findAll(Pageable page);

    Page<AssociadoDTO> findCargo(CargoPolitico cargoPolitico, Pageable page);

    AssociadoDTO search(Long id);

    AssociadoDTO vincular(Long idAssociado, Long idPartido);

    AssociadoDTO update(Long id, AssociadoFormDTO body);

    void delete(Long id);
}
