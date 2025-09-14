package com.espaciosdeportivos.service;

import com.espaciosdeportivos.dto.IncluyeDTO;
import java.util.List;

public interface IncluyeService {
    IncluyeDTO crearIncluye(IncluyeDTO incluyeDTO);
    IncluyeDTO actualizarIncluye(Long id, IncluyeDTO incluyeDTO);
    void eliminarIncluye(Long id);
    IncluyeDTO obtenerIncluyePorId(Long id);
    List<IncluyeDTO> listarIncluye();
}
