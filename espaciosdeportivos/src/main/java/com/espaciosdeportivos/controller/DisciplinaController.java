package com.espaciosdeportivos.controller;

import com.espaciosdeportivos.dto.DisciplinaDTO;
import com.espaciosdeportivos.service.DisciplinaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disciplinas")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @GetMapping
    public ResponseEntity<List<DisciplinaDTO>> getAll() {
        return ResponseEntity.ok(disciplinaService.listarDisciplinas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(disciplinaService.obtenerDisciplinaPorId(id));
    }

    @PostMapping
    public ResponseEntity<DisciplinaDTO> create(@Valid @RequestBody DisciplinaDTO dto) {
        return ResponseEntity.ok(disciplinaService.crearDisciplina(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisciplinaDTO> update(@PathVariable Long id, @Valid @RequestBody DisciplinaDTO dto) {
        return ResponseEntity.ok(disciplinaService.actualizarDisciplina(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        disciplinaService.eliminarDisciplina(id);
        return ResponseEntity.noContent().build();
    }
}
