
package com.espaciosdeportivos.controller;

import com.espaciosdeportivos.dto.IncluyeDTO;
import com.espaciosdeportivos.service.IncluyeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incluye")
public class IncluyeController {

    private final IncluyeService incluyeService;

    public IncluyeController(IncluyeService incluyeService) {
        this.incluyeService = incluyeService;
    }

    @GetMapping
    public ResponseEntity<List<IncluyeDTO>> getAll() {
        return ResponseEntity.ok(incluyeService.listarIncluye());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncluyeDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(incluyeService.obtenerIncluyePorId(id));
    }

    @PostMapping
    public ResponseEntity<IncluyeDTO> create(@Valid @RequestBody IncluyeDTO dto) {
        return ResponseEntity.ok(incluyeService.crearIncluye(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IncluyeDTO> update(@PathVariable Long id, @Valid @RequestBody IncluyeDTO dto) {
        return ResponseEntity.ok(incluyeService.actualizarIncluye(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        incluyeService.eliminarIncluye(id);
        return ResponseEntity.noContent().build();
    }
}
