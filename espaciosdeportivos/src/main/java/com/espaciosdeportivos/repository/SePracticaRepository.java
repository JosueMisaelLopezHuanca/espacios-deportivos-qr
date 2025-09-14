package com.espaciosdeportivos.repository;


import com.espaciosdeportivos.model.SePractica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SePracticaRepository extends JpaRepository<SePractica, Long> {
}
