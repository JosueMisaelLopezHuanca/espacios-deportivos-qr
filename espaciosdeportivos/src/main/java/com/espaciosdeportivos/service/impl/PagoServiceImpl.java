package com.espaciosdeportivos.service.impl;


import com.espaciosdeportivos.dto.PagoDTO;
import com.espaciosdeportivos.model.Pago;
import com.espaciosdeportivos.model.Reserva;
import com.espaciosdeportivos.repository.PagoRepository;
import com.espaciosdeportivos.repository.ReservaRepository;
import com.espaciosdeportivos.service.PagoService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagoServiceImpl implements PagoService {

    private final PagoRepository pagoRepository;
    private final ReservaRepository reservaRepository;

    public PagoServiceImpl(PagoRepository pagoRepository, ReservaRepository reservaRepository) {
        this.pagoRepository = pagoRepository;
        this.reservaRepository = reservaRepository;
    }

    @Override
    public PagoDTO crearPago(PagoDTO dto) {
        Reserva reserva = reservaRepository.findById(dto.getIdReserva())
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        Pago pago = new Pago();
        pago.setMonto(dto.getMonto());
        pago.setFecha(dto.getFecha());
        pago.setTipoPago(dto.getTipoPago());
        pago.setMetodoPago(dto.getMetodoPago());
        pago.setEstado(dto.getEstado());
        pago.setReserva(reserva);

        pago = pagoRepository.save(pago);
        dto.setIdPago(pago.getIdPago());
        return dto;
    }

    @Override
    public PagoDTO actualizarPago(Long id, PagoDTO dto) {
        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));
        Reserva reserva = reservaRepository.findById(dto.getIdReserva())
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        pago.setMonto(dto.getMonto());
        pago.setFecha(dto.getFecha());
        pago.setTipoPago(dto.getTipoPago());
        pago.setMetodoPago(dto.getMetodoPago());
        pago.setEstado(dto.getEstado());
        pago.setReserva(reserva);

        pagoRepository.save(pago);
        dto.setIdPago(pago.getIdPago());
        return dto;
    }

    @Override
    public void eliminarPago(Long id) {
        pagoRepository.deleteById(id);
    }

    @Override
    public PagoDTO obtenerPagoPorId(Long id) {
        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));
        return new PagoDTO(pago.getIdPago(), pago.getMonto(), pago.getFecha(),
                pago.getTipoPago(), pago.getMetodoPago(), pago.getEstado(),
                pago.getReserva().getIdReserva());
    }

    @Override
    public List<PagoDTO> listarPagos() {
        return pagoRepository.findAll().stream()
                .map(p -> new PagoDTO(p.getIdPago(), p.getMonto(), p.getFecha(),
                        p.getTipoPago(), p.getMetodoPago(), p.getEstado(),
                        p.getReserva().getIdReserva()))
                .collect(Collectors.toList());
    }
}
