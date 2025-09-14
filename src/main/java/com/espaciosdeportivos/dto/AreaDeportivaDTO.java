package com.espaciosdeportivos.dto;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;
import jakarta.validation.constraints.*;
//import java.time.LocalTime;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AreaDeportivaDTO implements Serializable {
    private Long id_areadeportiva;

    @NotBlank(message = "El nombre del área es obligatorio")
    private String nombre_area;

    @Size(max = 400, message = "La descripción no puede tener más de 400 caracteres")
    private String descripcion_area;

    @Email(message = "El email debe ser válido")
    private String email_area;

    @Pattern(regexp = "\\d{8}", message = "El teléfono debe tener 8  dígitos")
    private String telefono_area;

    @NotNull(message = "La hora de inicio es obligatoria")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime hora_inicio_area;

    @NotNull(message = "La hora de fin es obligatoria")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime hora_fin_area;

    @NotBlank(message = "El estado del área es obligatorio")
    private String estado_area;

    private String url_imagen;

    private Double latitud;
    private Double longitud;

    @NotNull(message = "La dirección es obligatoria")
    @Positive(message = "El ID de la zona debe ser un valor positivo")
    private Long id_zona;

    @NotNull(message = "El ID del administrador es obligatorio")
    @Positive(message = "El ID del administrador debe ser un valor positivo")   
    private Long id_administrador;

}