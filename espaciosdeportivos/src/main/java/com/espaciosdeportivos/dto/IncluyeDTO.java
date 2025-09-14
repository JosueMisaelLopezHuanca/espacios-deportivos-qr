package com.espaciosdeportivos.dto;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IncluyeDTO {

    private Long id; // opcional si se va a crear nuevo

    @NotNull(message = "El id de la cancha es obligatorio")
    private Long idCancha;

    @NotNull(message = "El id de la reserva es obligatorio")
    private Long idReserva;

    @NotNull(message = "El id de la disciplina es obligatorio")
    private Long idDisciplina;

    // ✅ Constructor personalizado para usar solo 3 campos: id, idReserva, idDisciplina
    public IncluyeDTO(Long id, Long idReserva, Long idDisciplina) {
        this.id = id;
        this.idCancha = null; // puedes asignar null si no lo usas aún
        this.idReserva = idReserva;
        this.idDisciplina = idDisciplina;
    }
}
