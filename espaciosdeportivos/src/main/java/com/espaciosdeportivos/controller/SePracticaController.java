package com.espaciosdeportivos.controller;

import com.espaciosdeportivos.dto.SePracticaDTO;
import com.espaciosdeportivos.service.SePracticaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sepractica")
public class SePracticaController {

    private final SePracticaService sePracticaService;

    public SePracticaController(SePracticaService sePracticaService) {
        this.sePracticaService = sePracticaService;
    }

    @GetMapping
    public ResponseEntity<List<SePracticaDTO>> getAll() {
        return ResponseEntity.ok(sePracticaService.listarSePractica());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SePracticaDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(sePracticaService.obtenerSePracticaPorId(id));
    }

    @PostMapping
    public ResponseEntity<SePracticaDTO> create(@Valid @RequestBody SePracticaDTO dto) {
        return ResponseEntity.ok(sePracticaService.crearSePractica(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SePracticaDTO> update(@PathVariable Long id, @Valid @RequestBody SePracticaDTO dto) {
        return ResponseEntity.ok(sePracticaService.actualizarSePractica(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        sePracticaService.eliminarSePractica(id);
        return ResponseEntity.noContent().build();
    }
}
