package com.generation.primerproyectospring.repositories;

// Se crea como una interfaz porque

import com.generation.primerproyectospring.entities.RegistroPacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroPacienteRepository extends JpaRepository<RegistroPacienteEntity, Long> {
}
