package com.espaciosdeportivos.service;


import com.espaciosdeportivos.dto.PagoDTO;
import java.util.List;

public interface PagoService {
    PagoDTO crearPago(PagoDTO pagoDTO);
    PagoDTO actualizarPago(Long id, PagoDTO pagoDTO);
    void eliminarPago(Long id);
    PagoDTO obtenerPagoPorId(Long id);
    List<PagoDTO> listarPagos();
}
