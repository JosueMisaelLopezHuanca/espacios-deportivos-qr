package com.espaciosdeportivos.service.impl;

import com.espaciosdeportivos.dto.IncluyeDTO;
import com.espaciosdeportivos.model.Incluye;
import com.espaciosdeportivos.model.Reserva;
import com.espaciosdeportivos.model.Disciplina;
import com.espaciosdeportivos.repository.IncluyeRepository;
import com.espaciosdeportivos.repository.ReservaRepository;
import com.espaciosdeportivos.repository.DisciplinaRepository;
import com.espaciosdeportivos.service.IncluyeService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncluyeServiceImpl implements IncluyeService {

    private final IncluyeRepository incluyeRepository;
    private final ReservaRepository reservaRepository;
    private final DisciplinaRepository disciplinaRepository;

    public IncluyeServiceImpl(IncluyeRepository incluyeRepository,
                              ReservaRepository reservaRepository,
                              DisciplinaRepository disciplinaRepository) {
        this.incluyeRepository = incluyeRepository;
        this.reservaRepository = reservaRepository;
        this.disciplinaRepository = disciplinaRepository;
    }

    @Override
    public IncluyeDTO crearIncluye(IncluyeDTO dto) {
        Reserva reserva = reservaRepository.findById(dto.getIdReserva())
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        Disciplina disciplina = disciplinaRepository.findById(dto.getIdDisciplina())
                .orElseThrow(() -> new RuntimeException("Disciplina no encontrada"));

        Incluye incluye = new Incluye();
        incluye.setReserva(reserva);
        incluye.setDisciplina(disciplina);

        incluye = incluyeRepository.save(incluye);
        dto.setId(incluye.getId());
        return dto;
    }

    @Override
    public IncluyeDTO actualizarIncluye(Long id, IncluyeDTO dto) {
        Incluye incluye = incluyeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Incluye no encontrado"));
        Reserva reserva = reservaRepository.findById(dto.getIdReserva())
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        Disciplina disciplina = disciplinaRepository.findById(dto.getIdDisciplina())
                .orElseThrow(() -> new RuntimeException("Disciplina no encontrada"));

        incluye.setReserva(reserva);
        incluye.setDisciplina(disciplina);

        incluyeRepository.save(incluye);
        dto.setId(incluye.getId());
        return dto;
    }

    @Override
    public void eliminarIncluye(Long id) {
        incluyeRepository.deleteById(id);
    }
    @Override
    public IncluyeDTO obtenerIncluyePorId(Long id) {
        Incluye incluye = incluyeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Incluye no encontrado"));
        return new IncluyeDTO(incluye.getId(),
                incluye.getReserva().getIdReserva(),
                incluye.getDisciplina().getIdDisciplina());
    }

    @Override
    public List<IncluyeDTO> listarIncluye() {
        return incluyeRepository.findAll().stream()
                .map(i -> new IncluyeDTO(i.getId(),
                        i.getReserva().getIdReserva(),
                        i.getDisciplina().getIdDisciplina()))
                .collect(Collectors.toList());
    }
}
