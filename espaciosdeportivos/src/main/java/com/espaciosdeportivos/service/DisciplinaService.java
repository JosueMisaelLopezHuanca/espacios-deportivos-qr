package com.espaciosdeportivos.service;


import com.espaciosdeportivos.dto.DisciplinaDTO;
import java.util.List;

public interface DisciplinaService {
    DisciplinaDTO crearDisciplina(DisciplinaDTO disciplinaDTO);
    DisciplinaDTO actualizarDisciplina(Long id, DisciplinaDTO disciplinaDTO);
    void eliminarDisciplina(Long id);
    DisciplinaDTO obtenerDisciplinaPorId(Long id);
    List<DisciplinaDTO> listarDisciplinas();
}
