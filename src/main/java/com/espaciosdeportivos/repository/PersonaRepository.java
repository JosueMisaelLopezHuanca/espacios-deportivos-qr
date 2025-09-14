package com.espaciosdeportivos.repository;

import com.espaciosdeportivos.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    // Buscar por nombre (contiene, sin importar mayúsculas/minúsculas)
    List<Persona> findByNombreIgnoreCaseContaining(String nombre);
}
