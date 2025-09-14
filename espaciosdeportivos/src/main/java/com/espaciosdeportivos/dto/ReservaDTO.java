package com.espaciosdeportivos.dto;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDTO {
    private Long idReserva;
    private LocalDate fechaCreacion;
    private LocalDate fechaReserva;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String estadoReserva;
    private Double montoTotal;
    private String observaciones;
    private Long idCliente; // relacion con Cliente (solo id)
}
