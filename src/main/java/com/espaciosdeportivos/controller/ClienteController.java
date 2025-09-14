package com.espaciosdeportivos.controller;

import com.espaciosdeportivos.dto.ClienteDTO;
import com.espaciosdeportivos.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ClienteDTO crear(@RequestBody ClienteDTO dto) {
        return service.crear(dto);
    }

    @PutMapping("/{id}")
    public ClienteDTO actualizar(@PathVariable Long id, @RequestBody ClienteDTO dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @GetMapping("/{id}")
    public ClienteDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping
    public List<ClienteDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/buscar/{nombre}")
    public List<ClienteDTO> buscarPorNombre(@PathVariable String nombre) {
        return service.buscarPorNombre(nombre);
    }
}
