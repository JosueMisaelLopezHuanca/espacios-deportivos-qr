package com.espaciosdeportivos.dto;

import lombok.*;
import jakarta.validation.constraints.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MacrodistritoDTO {
    private Long idMacrodistrito;

    @NotBlank(message = "El nombre del macrodistrito es obligatorio")
    private String nombre;

    @Size(max = 400, message = "La descripción no puede tener más de 400 caracteres")   
    private String descripcion;

}
