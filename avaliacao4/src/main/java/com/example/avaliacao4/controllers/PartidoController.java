package com.example.avaliacao4.controllers;

import com.example.avaliacao4.dto.AssociadoDTO;
import com.example.avaliacao4.dto.AssociadoFormDTO;
import com.example.avaliacao4.dto.PartidoDTO;
import com.example.avaliacao4.dto.PartidoFormDTO;
import com.example.avaliacao4.entities.CargoPolitico;
import com.example.avaliacao4.entities.Ideologia;
import com.example.avaliacao4.repository.PartidoRepository;
import com.example.avaliacao4.services.PartidoService;
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
@RequestMapping("/partidos")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;


    @PostMapping
    public ResponseEntity<PartidoDTO> save(@RequestBody @Valid PartidoFormDTO body) {
        PartidoDTO partidoDTO = this.partidoService.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(partidoDTO);
    }

    @GetMapping
    public ResponseEntity<Page<PartidoDTO>> findIdeologia(@RequestParam(required = false) Ideologia ideologia,
                                                        @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable page
    ) {
        Page<PartidoDTO> partidoDTO = this.partidoService.findIdeologia(ideologia,page);
        return ResponseEntity.ok(partidoDTO);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PartidoDTO> search(@PathVariable Long id) {
        PartidoDTO partidoDTO = this.partidoService.search(id);
        return ResponseEntity.ok(partidoDTO);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PartidoDTO> update(@PathVariable Long id, @RequestBody @Valid PartidoFormDTO body) {
        PartidoDTO partidoDTO = this.partidoService.update(id, body);
        return ResponseEntity.ok(partidoDTO);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.partidoService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
