package com.espaciosdeportivos.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagoDTO {
    private Long idPago;
    private Double monto;
    private LocalDate fecha;
    private String tipoPago;
    private String metodoPago;
    private String estado;
    private Long idReserva; // relacion con Reserva (solo id)
}
