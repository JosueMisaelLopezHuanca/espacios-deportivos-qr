package com.espaciosdeportivos.service;

import com.espaciosdeportivos.dto.SePracticaDTO;
import java.util.List;

public interface SePracticaService {
    SePracticaDTO crearSePractica(SePracticaDTO sePracticaDTO);
    SePracticaDTO actualizarSePractica(Long id, SePracticaDTO sePracticaDTO);
    void eliminarSePractica(Long id);
    SePracticaDTO obtenerSePracticaPorId(Long id);
    List<SePracticaDTO> listarSePractica();
}
