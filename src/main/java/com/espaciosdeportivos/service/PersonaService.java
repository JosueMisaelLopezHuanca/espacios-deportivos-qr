package com.espaciosdeportivos.service;

import com.espaciosdeportivos.dto.PersonaDTO;
import java.util.List;

public interface PersonaService {

    PersonaDTO crear(PersonaDTO personaDTO);

    PersonaDTO actualizar(Long id, PersonaDTO personaDTO);

    void eliminar(Long id);

    PersonaDTO buscarPorId(Long id);

    List<PersonaDTO> listarTodos();

    List<PersonaDTO> buscarPorNombre(String nombre);
}
