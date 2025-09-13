package com.espaciosdeportivos.dto;

import lombok.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MacrodistritoDTO implements Serializable {
    private Long idMacrodistrito;

    @NotBlank(message = "El nombre del macrodistrito es obligatorio")
    private String nombre;

    @Size(max = 400, message = "La descripción no puede tener más de 400 caracteres")   
    private String descripcion;

}
