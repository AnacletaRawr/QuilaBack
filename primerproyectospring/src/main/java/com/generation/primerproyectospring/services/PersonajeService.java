package com.generation.primerproyectospring.services;



import com.generation.primerproyectospring.entities.PersonajeEntity;

import java.util.List;
import java.util.Optional;

//Interfaz del service donde declaramos los métodos, por eso es una interfaz
public interface PersonajeService {

    //Declaramos el primer método que es para traernos una lista de los personaje
    List<PersonajeEntity> findAll();
    Optional<PersonajeEntity> findById(Long id);

    PersonajeEntity save(PersonajeEntity personajeEntity);

    void delete(Long id);

    public PersonajeEntity editarPersonajePorId(Long pesonajeId, PersonajeEntity personajeEntity);
}