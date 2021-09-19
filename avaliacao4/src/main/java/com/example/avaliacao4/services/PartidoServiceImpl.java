package com.example.avaliacao4.services;

import com.example.avaliacao4.dto.AssociadoDTO;
import com.example.avaliacao4.dto.PartidoDTO;
import com.example.avaliacao4.dto.PartidoFormDTO;
import com.example.avaliacao4.entities.Associado;
import com.example.avaliacao4.entities.Ideologia;
import com.example.avaliacao4.entities.Partido;
import com.example.avaliacao4.exceptions.BusinessException;
import com.example.avaliacao4.repository.PartidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartidoServiceImpl implements PartidoService{

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PartidoRepository repository;


    @Override
    public PartidoDTO save(PartidoFormDTO body) {
        Partido partido = this.repository.save(mapper.map(body, Partido.class));
        return mapper.map(partido, PartidoDTO.class);
    }

    @Override
    public Page<PartidoDTO> findAll(Pageable page) {
        Page<Partido> partidos = this.repository.findAll(page);
        List<PartidoDTO> listpartidos = partidos.getContent()
                .stream()
                .map(partido -> mapper.map(partido, PartidoDTO.class))
                .collect(Collectors.toList());
        return new PageImpl<PartidoDTO>(listpartidos, page, partidos.getTotalElements());
    }

    @Override
    public PartidoDTO search(Long id) {
        Partido partido = this.repository.findById(id)
                .orElseThrow(() -> new BusinessException(404, "NOT_FOUND", "Partido not found"));
        return mapper.map(partido, PartidoDTO.class);
    }

    @Override
    public PartidoDTO update(Long id, PartidoFormDTO body) {
        Partido partido = this.repository.findById(id)
                .orElseThrow(() -> new BusinessException(404, "NOT_FOUND", "Partido not found"));
        partido.setNome(body.getNome());
        partido.setIdeologia(body.getIdeologia());
        partido.setSigla(body.getSigla());
        partido.setDataFundacao(body.getDataFundacao());
        Partido updated = this.repository.save(partido);
        return mapper.map(updated, PartidoDTO.class);
    }

    @Override
    public Page<PartidoDTO> findIdeologia(Ideologia ideologia, Pageable page) {
        Page<Partido> partidos = this.repository.findByIdeologia(ideologia,page);
        List<PartidoDTO> listPartidos = partidos.getContent()
                .stream()
                .map(partido -> mapper.map(partido, PartidoDTO.class))
                .collect(Collectors.toList());
        return new PageImpl<PartidoDTO>(listPartidos, page, partidos.getTotalElements());
    }

    @Override
    public void delete(Long id) {
        Partido partido = this.repository.findById(id)
                .orElseThrow(() -> new BusinessException(404, "NOT_FOUND", "Associado not found"));
        this.repository.delete(partido);

    }
}
