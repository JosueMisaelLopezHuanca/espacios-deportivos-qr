package com.espaciosdeportivos.controller;

import com.espaciosdeportivos.dto.UsuarioControlDTO;
import com.espaciosdeportivos.service.UsuarioControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario-control")
public class UsuarioControlController {

    @Autowired
    private UsuarioControlService service;

    @PostMapping
    public UsuarioControlDTO crear(@RequestBody UsuarioControlDTO dto) {
        return service.crear(dto);
    }

    @PutMapping("/{id}")
    public UsuarioControlDTO actualizar(@PathVariable Long id, @RequestBody UsuarioControlDTO dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @GetMapping("/{id}")
    public UsuarioControlDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping
    public List<UsuarioControlDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/buscar/{nombre}")
    public List<UsuarioControlDTO> buscarPorNombre(@PathVariable String nombre) {
        return service.buscarPorNombre(nombre);
    }
}
