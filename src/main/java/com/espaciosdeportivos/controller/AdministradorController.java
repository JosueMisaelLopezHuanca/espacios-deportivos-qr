package com.espaciosdeportivos.controller;

import com.espaciosdeportivos.dto.AdministradorDTO;
import com.espaciosdeportivos.service.AdministradorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administradores")
public class AdministradorController {

    private final AdministradorService service;

    public AdministradorController(AdministradorService service) {
        this.service = service;
    }

    @PostMapping
    public AdministradorDTO crear(@RequestBody AdministradorDTO dto) {
        return service.crear(dto);
    }

    @PutMapping("/{id}")
    public AdministradorDTO actualizar(@PathVariable Long id, @RequestBody AdministradorDTO dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @GetMapping("/{id}")
    public AdministradorDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping
    public List<AdministradorDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/buscar/{nombre}")
    public List<AdministradorDTO> buscarPorNombre(@PathVariable String nombre) {
        return service.buscarPorNombre(nombre);
    }
}
