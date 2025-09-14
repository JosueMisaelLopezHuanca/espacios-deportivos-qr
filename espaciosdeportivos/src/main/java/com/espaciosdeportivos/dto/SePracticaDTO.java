package com.espaciosdeportivos.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SePracticaDTO {
    private Long id; // opcional si se va a crear nuevo

    @NotNull(message = "El id de la cancha es obligatorio")
    private Long idCancha;

    @NotNull(message = "El id de la disciplina es obligatorio")
    private Long idDisciplina;
}
