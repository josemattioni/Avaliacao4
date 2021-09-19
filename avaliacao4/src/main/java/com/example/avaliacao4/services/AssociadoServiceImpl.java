package com.example.avaliacao4.services;

import com.example.avaliacao4.dto.AssociadoDTO;
import com.example.avaliacao4.dto.AssociadoFormDTO;
import com.example.avaliacao4.entities.Associado;
import com.example.avaliacao4.entities.CargoPolitico;
import com.example.avaliacao4.entities.Partido;
import com.example.avaliacao4.exceptions.BusinessException;
import com.example.avaliacao4.repository.AssociadoRepository;
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
public class AssociadoServiceImpl implements AssociadoService {

    @Autowired
    private AssociadoRepository repository;

    @Autowired
    private PartidoRepository partidoRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public AssociadoDTO save(AssociadoFormDTO body) {
        Associado associado = this.repository.save(mapper.map(body, Associado.class));
        return mapper.map(associado, AssociadoDTO.class);
    }

    @Override
    public Page<AssociadoDTO> findAll(Pageable page) {
        Page<Associado> associados = this.repository.findAll(page);
        List<AssociadoDTO> listAssociados = associados.getContent()
                .stream()
                .map(associado -> mapper.map(associado, AssociadoDTO.class))
                .collect(Collectors.toList());
        return new PageImpl<AssociadoDTO>(listAssociados, page, associados.getTotalElements());
    }

    @Override
    public Page<AssociadoDTO> findCargo(CargoPolitico cargoPolitico, Pageable page) {
        Page<Associado> associados = this.repository.findByCargoPolitico(cargoPolitico,page);
        List<AssociadoDTO> listAssociados = associados.getContent()
                .stream()
                .map(associado -> mapper.map(associado, AssociadoDTO.class))
                .collect(Collectors.toList());
        return new PageImpl<AssociadoDTO>(listAssociados, page, associados.getTotalElements());
    }

    @Override
    public AssociadoDTO search(Long id) {
        Associado associado = this.repository.findById(id)
                .orElseThrow(() -> new BusinessException(404, "NOT_FOUND", "Associado not found"));
        return mapper.map(associado, AssociadoDTO.class);
    }

    @Override
    public AssociadoDTO vincular(Long idAssociado, Long idPartido) {
        Partido partido = this.partidoRepository.findById(idPartido)
                .orElseThrow(() -> new BusinessException(404, "NOT_FOUND", "Partido not found"));
        Associado associado = this.repository.findById(idAssociado)
                .orElseThrow(() -> new BusinessException(404, "NOT_FOUND", "Associado not found"));
        associado.setPartido(partido);
        Associado updated = this.repository.save(associado);
        return mapper.map(updated, AssociadoDTO.class);


    }


    @Override
    public AssociadoDTO update(Long id, AssociadoFormDTO body) {
        Associado associado = this.repository.findById(id)
                .orElseThrow(() -> new BusinessException(404, "NOT_FOUND", "Associado not found"));
        associado.setNome(body.getNome());
        associado.setCargoPolitico(body.getCargoPolitico());
        associado.setSexo(body.getSexo());
        associado.setDataNascimento(body.getDataNascimento());
        Associado updated = this.repository.save(associado);
        return mapper.map(updated, AssociadoDTO.class);
    }

    @Override
    public void delete(Long id) {
            Associado associado = this.repository.findById(id)
                    .orElseThrow(() -> new BusinessException(404, "NOT_FOUND", "Associado not found"));
            this.repository.delete(associado);
    }
}
