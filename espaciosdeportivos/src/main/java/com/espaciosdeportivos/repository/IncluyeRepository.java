package com.espaciosdeportivos.repository;


import com.espaciosdeportivos.model.Incluye;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncluyeRepository extends JpaRepository<Incluye, Long> {
}
