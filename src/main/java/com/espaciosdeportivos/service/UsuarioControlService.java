package com.espaciosdeportivos.service;

import com.espaciosdeportivos.dto.UsuarioControlDTO;
import java.util.List;

public interface UsuarioControlService {

    UsuarioControlDTO crear(UsuarioControlDTO dto);

    UsuarioControlDTO actualizar(Long id, UsuarioControlDTO dto);

    void eliminar(Long id);

    UsuarioControlDTO buscarPorId(Long id);

    List<UsuarioControlDTO> listarTodos();

    List<UsuarioControlDTO> buscarPorNombre(String nombre);
}
