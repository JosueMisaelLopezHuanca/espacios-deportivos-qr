package com.espaciosdeportivos.controller;

import com.espaciosdeportivos.dto.InvitadoDTO;
import com.espaciosdeportivos.service.InvitadoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invitados")
public class InvitadoController {

    private final InvitadoService service;

    public InvitadoController(InvitadoService service) {
        this.service = service;
    }

    @PostMapping
    public InvitadoDTO crear(@RequestBody InvitadoDTO dto) {
        return service.crear(dto);
    }

    @PutMapping("/{id}")
    public InvitadoDTO actualizar(@PathVariable Long id, @RequestBody InvitadoDTO dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @GetMapping("/{id}")
    public InvitadoDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping
    public List<InvitadoDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/buscar/{nombre}")
    public List<InvitadoDTO> buscarPorNombre(@PathVariable String nombre) {
        return service.buscarPorNombre(nombre);
    }
}
