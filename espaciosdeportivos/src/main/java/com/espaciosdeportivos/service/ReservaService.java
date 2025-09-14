package com.espaciosdeportivos.service;


import com.espaciosdeportivos.dto.ReservaDTO;
import java.util.List;

public interface ReservaService {
    ReservaDTO crearReserva(ReservaDTO reservaDTO);
    ReservaDTO actualizarReserva(Long id, ReservaDTO reservaDTO);
    void eliminarReserva(Long id);
    ReservaDTO obtenerReservaPorId(Long id);
    List<ReservaDTO> listarReservas();
}
