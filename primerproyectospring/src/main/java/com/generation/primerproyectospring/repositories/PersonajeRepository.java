package com.generation.primerproyectospring.repositories;


import com.generation.primerproyectospring.entities.PersonajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRepository extends JpaRepository<PersonajeEntity, Long> {


}