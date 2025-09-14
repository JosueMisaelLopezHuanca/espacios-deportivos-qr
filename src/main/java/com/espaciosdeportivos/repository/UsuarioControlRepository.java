package com.espaciosdeportivos.repository;

import com.espaciosdeportivos.model.UsuarioControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsuarioControlRepository extends JpaRepository<UsuarioControl, Long> {
    List<UsuarioControl> findByNombreContainingIgnoreCase(String nombre);
}
