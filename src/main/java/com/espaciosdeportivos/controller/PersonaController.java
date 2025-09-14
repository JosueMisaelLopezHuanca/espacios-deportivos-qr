package com.espaciosdeportivos.controller;

import com.espaciosdeportivos.dto.PersonaDTO;
import com.espaciosdeportivos.service.PersonaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    private final PersonaService service;

    public PersonaController(PersonaService service) {
        this.service = service;
    }

    @PostMapping
    public PersonaDTO crear(@RequestBody PersonaDTO dto) {
        return service.crear(dto);
    }

    @PutMapping("/{id}")
    public PersonaDTO actualizar(@PathVariable Long id, @RequestBody PersonaDTO dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @GetMapping("/{id}")
    public PersonaDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping
    public List<PersonaDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/buscar/{nombre}")
    public List<PersonaDTO> buscarPorNombre(@PathVariable String nombre) {
        return service.buscarPorNombre(nombre);
    }
}
