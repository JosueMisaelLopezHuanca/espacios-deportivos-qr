package com.espaciosdeportivos.service;

import com.espaciosdeportivos.dto.AdministradorDTO;
import java.util.List;

public interface AdministradorService {

    AdministradorDTO crear(AdministradorDTO dto);

    AdministradorDTO actualizar(Long id, AdministradorDTO dto);

    void eliminar(Long id);

    AdministradorDTO buscarPorId(Long id);

    List<AdministradorDTO> listarTodos();

    List<AdministradorDTO> buscarPorNombre(String nombre);
}
