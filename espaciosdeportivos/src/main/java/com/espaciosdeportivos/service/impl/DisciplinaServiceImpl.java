package com.espaciosdeportivos.service.impl;

import com.espaciosdeportivos.dto.DisciplinaDTO;
import com.espaciosdeportivos.model.Disciplina;
import com.espaciosdeportivos.repository.DisciplinaRepository;
import com.espaciosdeportivos.service.DisciplinaService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DisciplinaServiceImpl implements DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    public DisciplinaServiceImpl(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    @Override
    public DisciplinaDTO crearDisciplina(DisciplinaDTO dto) {
        Disciplina disciplina = new Disciplina();
        disciplina.setNombre(dto.getNombre());
        disciplina.setDescripcion(dto.getDescripcion());
        disciplina = disciplinaRepository.save(disciplina);
        dto.setIdDisciplina(disciplina.getIdDisciplina());
        return dto;
    }

    @Override
    public DisciplinaDTO actualizarDisciplina(Long id, DisciplinaDTO dto) {
        Disciplina disciplina = disciplinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disciplina no encontrada"));
        disciplina.setNombre(dto.getNombre());
        disciplina.setDescripcion(dto.getDescripcion());
        disciplinaRepository.save(disciplina);
        dto.setIdDisciplina(disciplina.getIdDisciplina());
        return dto;
    }

    @Override
    public void eliminarDisciplina(Long id) {
        disciplinaRepository.deleteById(id);
    }

    @Override
    public DisciplinaDTO obtenerDisciplinaPorId(Long id) {
        Disciplina disciplina = disciplinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disciplina no encontrada"));
        return new DisciplinaDTO(disciplina.getIdDisciplina(), disciplina.getNombre(), disciplina.getDescripcion());
    }

    @Override
    public List<DisciplinaDTO> listarDisciplinas() {
        return disciplinaRepository.findAll().stream()
                .map(d -> new DisciplinaDTO(d.getIdDisciplina(), d.getNombre(), d.getDescripcion()))
                .collect(Collectors.toList());
    }
}
