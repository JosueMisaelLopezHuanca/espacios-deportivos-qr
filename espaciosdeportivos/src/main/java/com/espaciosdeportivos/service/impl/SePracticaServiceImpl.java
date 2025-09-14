package com.espaciosdeportivos.service.impl;

import com.espaciosdeportivos.dto.SePracticaDTO;
import com.espaciosdeportivos.model.SePractica;
import com.espaciosdeportivos.model.Disciplina;
import com.espaciosdeportivos.repository.SePracticaRepository;
import com.espaciosdeportivos.service.SePracticaService;
import com.espaciosdeportivos.repository.DisciplinaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SePracticaServiceImpl implements SePracticaService {

    private final SePracticaRepository sePracticaRepository;
    private final DisciplinaRepository disciplinaRepository;

    public SePracticaServiceImpl(SePracticaRepository sePracticaRepository,
                                 DisciplinaRepository disciplinaRepository) {
        this.sePracticaRepository = sePracticaRepository;
        this.disciplinaRepository = disciplinaRepository;
    }

    @Override
    public SePracticaDTO crearSePractica(SePracticaDTO dto) {
        Disciplina disciplina = disciplinaRepository.findById(dto.getIdDisciplina())
                .orElseThrow(() -> new RuntimeException("Disciplina no encontrada"));

        SePractica sePractica = new SePractica();
        sePractica.setDisciplina(disciplina);
        // Si en el futuro agregas Cancha, se setea aquí

        sePractica = sePracticaRepository.save(sePractica);
        dto.setId(sePractica.getId());
        return dto;
    }

    @Override
    public SePracticaDTO actualizarSePractica(Long id, SePracticaDTO dto) {
        SePractica sePractica = sePracticaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SePractica no encontrado"));
        Disciplina disciplina = disciplinaRepository.findById(dto.getIdDisciplina())
                .orElseThrow(() -> new RuntimeException("Disciplina no encontrada"));

        sePractica.setDisciplina(disciplina);
        sePracticaRepository.save(sePractica);
        dto.setId(sePractica.getId());
        return dto;
    }

    @Override
    public void eliminarSePractica(Long id) {
        sePracticaRepository.deleteById(id);
    }

    @Override
    public SePracticaDTO obtenerSePracticaPorId(Long id) {
        SePractica sePractica = sePracticaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SePractica no encontrado"));
        return new SePracticaDTO(sePractica.getId(),
                null,  // idCancha si agregas en el futuro
                sePractica.getDisciplina().getIdDisciplina());
    }

    @Override
    public List<SePracticaDTO> listarSePractica() {
        return sePracticaRepository.findAll().stream()
                .map(s -> new SePracticaDTO(s.getId(),
                        null, // idCancha
                        s.getDisciplina().getIdDisciplina()))
                .collect(Collectors.toList());
    }
}
