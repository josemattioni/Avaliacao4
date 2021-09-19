package com.example.avaliacao4.controllers;

import com.example.avaliacao4.dto.AssociadoDTO;
import com.example.avaliacao4.dto.AssociadoFormDTO;
import com.example.avaliacao4.dto.VinculoFormDTO;
import com.example.avaliacao4.entities.CargoPolitico;
import com.example.avaliacao4.repository.AssociadoRepository;
import com.example.avaliacao4.services.AssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/associados")
public class AssociadoController {

    @Autowired
    private AssociadoService associadoService;


    @PostMapping
    public ResponseEntity<AssociadoDTO> save(@RequestBody @Valid AssociadoFormDTO body) {
        AssociadoDTO associadoDTO = this.associadoService.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(associadoDTO);
    }

    @GetMapping
    public ResponseEntity<Page<AssociadoDTO>> findCargo(@RequestParam(required = false) CargoPolitico cargoPolitico,
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable page
    ) {
        Page<AssociadoDTO> associadoDTO = this.associadoService.findCargo(cargoPolitico,page);
        return ResponseEntity.ok(associadoDTO);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AssociadoDTO> search(@PathVariable Long id) {
        AssociadoDTO associadoDTO = this.associadoService.search(id);
        return ResponseEntity.ok(associadoDTO);
    }
    @PostMapping(path = "/partidos")
    public ResponseEntity<AssociadoDTO> vincular(@RequestBody VinculoFormDTO body) {
        AssociadoDTO associadoDTO = this.associadoService.vincular(body.getIdAssociado(),body.getIdPartido());
        return ResponseEntity.ok(associadoDTO);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AssociadoDTO> update(@PathVariable Long id, @RequestBody @Valid AssociadoFormDTO body) {
        AssociadoDTO associadoDTO = this.associadoService.update(id, body);
        return ResponseEntity.ok(associadoDTO);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.associadoService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
