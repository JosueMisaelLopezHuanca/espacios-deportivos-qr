package com.espaciosdeportivos.service.impl;

import com.espaciosdeportivos.dto.ReservaDTO;
import com.espaciosdeportivos.model.Reserva;
import com.espaciosdeportivos.repository.ReservaRepository;
import com.espaciosdeportivos.service.ReservaService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public ReservaDTO crearReserva(ReservaDTO dto) {
        Reserva reserva = new Reserva();
        reserva.setFechaCreacion(dto.getFechaCreacion());
        reserva.setFechaReserva(dto.getFechaReserva());
        reserva.setHoraInicio(dto.getHoraInicio());
        reserva.setHoraFin(dto.getHoraFin());
        reserva.setEstadoReserva(dto.getEstadoReserva());
        reserva.setMontoTotal(dto.getMontoTotal());
        reserva.setObservaciones(dto.getObservaciones());
        // Aquí podrías setear cliente si lo tienes implementado
        reserva = reservaRepository.save(reserva);
        dto.setIdReserva(reserva.getIdReserva());
        return dto;
    }

    @Override
    public ReservaDTO actualizarReserva(Long id, ReservaDTO dto) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        reserva.setFechaCreacion(dto.getFechaCreacion());
        reserva.setFechaReserva(dto.getFechaReserva());
        reserva.setHoraInicio(dto.getHoraInicio());
        reserva.setHoraFin(dto.getHoraFin());
        reserva.setEstadoReserva(dto.getEstadoReserva());
        reserva.setMontoTotal(dto.getMontoTotal());
        reserva.setObservaciones(dto.getObservaciones());
        reservaRepository.save(reserva);
        dto.setIdReserva(reserva.getIdReserva());
        return dto;
    }

    @Override
    public void eliminarReserva(Long id) {
        reservaRepository.deleteById(id);
    }

    @Override
    public ReservaDTO obtenerReservaPorId(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        return new ReservaDTO(reserva.getIdReserva(), reserva.getFechaCreacion(),
                reserva.getFechaReserva(), reserva.getHoraInicio(), reserva.getHoraFin(),
                reserva.getEstadoReserva(), reserva.getMontoTotal(), reserva.getObservaciones(), null);
    }

    @Override
    public List<ReservaDTO> listarReservas() {
        return reservaRepository.findAll().stream()
                .map(r -> new ReservaDTO(r.getIdReserva(), r.getFechaCreacion(),
                        r.getFechaReserva(), r.getHoraInicio(), r.getHoraFin(),
                        r.getEstadoReserva(), r.getMontoTotal(), r.getObservaciones(), null))
                .collect(Collectors.toList());
    }
}
