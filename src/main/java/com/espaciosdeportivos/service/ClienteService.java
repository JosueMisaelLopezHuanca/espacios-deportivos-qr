package com.espaciosdeportivos.service;

import com.espaciosdeportivos.dto.ClienteDTO;
import java.util.List;

public interface ClienteService {

    ClienteDTO crear(ClienteDTO dto);

    ClienteDTO actualizar(Long id, ClienteDTO dto);

    void eliminar(Long id);

    ClienteDTO buscarPorId(Long id);

    List<ClienteDTO> listarTodos();

    List<ClienteDTO> buscarPorNombre(String nombre);
}
