package com.espaciosdeportivos.dto;

import lombok.*;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ZonaDTO {
    private Long idZona;

    @NotBlank(message = "El nombre de la zona es obligatorio")
    private String nombre;
    
    @Size(max = 400, message = "La descripción no puede tener más de 400 caracteres")   
    private String descripcion;

    
}
