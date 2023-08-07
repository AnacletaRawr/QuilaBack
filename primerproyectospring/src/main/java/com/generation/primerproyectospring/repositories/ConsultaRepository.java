package com.generation.primerproyectospring.repositories;

import com.generation.primerproyectospring.entities.ConsultaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaEntity, Long> {

}
