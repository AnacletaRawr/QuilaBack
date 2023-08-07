package com.generation.primerproyectospring.controllers;


import com.generation.primerproyectospring.entities.PersonajeEntity;
import com.generation.primerproyectospring.services.PersonajeService;
import com.generation.primerproyectospring.services.PersonajeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")//Nos permite indica que se aceptan peticiones desde cualquier lado
@RequestMapping("/api")//Esta anotación nos permite indicar el enrutamiento base
public class PersonajeController {

    @Autowired
    private PersonajeServiceImpl personajeService;

    //Acá mediante @RequestParam pasamos la edad de manera dinámica como parámetro
    //La ruta sería: http://localhost:8080/api/holi?edad=30
    @RequestMapping(value = "holi", method = RequestMethod.GET)
    private String miEdad(@RequestParam(value = "edad") String edad) {
        return "Mi edad es: " + edad;
    }

    //Acá mediante @PathVariable pasamos el año de manera dinámica como parte de la ruta
    //La ruta sería: http://localhost:8080/api/holo/2023
    @GetMapping("holo/{a}")
    private String anio(@PathVariable("a") Integer anio) {
        return "El año es: " + anio;
    }

    @GetMapping("personaje/{id}")
    //ResponseEntity es una clase que además de permitirnos traer nuestro objeto, nos permite indicar el status de la petición
    private ResponseEntity<PersonajeEntity> buscarPorId(@PathVariable("id") Long id) {
        Optional<PersonajeEntity> personajeElegido = personajeService.findById(id);
        return ResponseEntity.ok(personajeElegido.get());//El Optional(No ResponseEntity) tiene un método .get() qué permite obtener el valor
    }

    @GetMapping("lista")
    public List<PersonajeEntity> enlistar() {
        //System.out.println(personajeService.findAll());
        //System.out.println("hola");
        return personajeService.findAll();
    }

    @PostMapping("nuevo")
    public  ResponseEntity<PersonajeEntity> nuevo(@RequestBody PersonajeEntity personajeEntity) {
        //System.out.println(personajeEntity.getPersonajeName());
        //PersonajeEntity nuevoPersonaje = personajeService.save(personajeEntity);
        return ResponseEntity.ok(personajeService.save(personajeEntity));
    }

    @DeleteMapping("borrar/{id}")
    public void eliminarPersona(@PathVariable("id")Long id) {
        personajeService.delete(id);
    }

    @PutMapping("editar/{id}")
    public ResponseEntity<PersonajeEntity> editarPersonajePorId(@PathVariable("id") Long personajeId,
                                                                @RequestBody PersonajeEntity personajeEditar) {
        return ResponseEntity.ok(personajeService.editarPersonajePorId(personajeId,personajeEditar));
    }

}