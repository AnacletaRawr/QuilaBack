package com.generation.primerproyectospring.controllers;

import com.generation.primerproyectospring.entities.PersonajeEntity;
import com.generation.primerproyectospring.entities.RegistroPacienteEntity;
import com.generation.primerproyectospring.services.PersonajeServiceImpl;
import com.generation.primerproyectospring.services.RegistroPacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("paciente")
public class RegistroPacienteController {

    @Autowired
    RegistroPacienteServiceImpl registroPacienteService;

    @Autowired
    PersonajeServiceImpl personajeService;

    @GetMapping("/lista")
    public ResponseEntity<List<RegistroPacienteEntity>> obtenerTodosPacientes(){
        return ResponseEntity.ok(registroPacienteService.obtenerPacientesRegistrados());
    }

    @PostMapping("nuevo/{id}")
    public  ResponseEntity<RegistroPacienteEntity> nuevoRegistro(@PathVariable("id") Long personajeId, @RequestBody RegistroPacienteEntity nuevoPaciente) {
        PersonajeEntity personajeElegido = personajeService.findById(personajeId).get();
        nuevoPaciente.setPacienteEntity(personajeElegido);
        return ResponseEntity.ok(registroPacienteService.crearNuevoRegistro(nuevoPaciente));
    }

    @GetMapping("/{id}")
    public  ResponseEntity<RegistroPacienteEntity> obtenerPacientePorId(@PathVariable Long id) {
        return ResponseEntity.ok(registroPacienteService.buscarPacientePorId(id));
    }

}
