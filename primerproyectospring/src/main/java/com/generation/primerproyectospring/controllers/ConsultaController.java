package com.generation.primerproyectospring.controllers;

import com.generation.primerproyectospring.entities.ConsultaEntity;
import com.generation.primerproyectospring.entities.RegistroPacienteEntity;
import com.generation.primerproyectospring.services.ConsultaServiceImpl;
import com.generation.primerproyectospring.services.RegistroPacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")//Nos permite indica que se aceptan peticiones desde cualquier lado
@RequestMapping("/consulta")//Esta anotación nos permite indicar el enrutamiento base
public class ConsultaController {
    @Autowired
    ConsultaServiceImpl consultaService;

    @Autowired
    RegistroPacienteServiceImpl registroPacienteService;

    @PostMapping("/nueva/{id}")
    public ResponseEntity<ConsultaEntity> crearNuevaConsulta(@PathVariable("id") Long idPaciente, @RequestBody ConsultaEntity nuevaConsulta) {
        // Primero hay que buscar si existe el paciente con el id
        // Entonces guardamos a este paciente en una variable como "pacienteElegido"
        RegistroPacienteEntity pacienteElegido = registroPacienteService.buscarPacientePorId(idPaciente);
        // Ahora, se debe asignar nuestro paciente a la consulta que estamos creando, mediante el método set de consulta
        nuevaConsulta.setPacienteConsulta(pacienteElegido);
        // Ahora, retornamos una entidad response, que resive una consultaService, que a su vez crea la nueva consulta y la guarda en la BD
        return ResponseEntity.ok(consultaService.crearNuevaConsulta(nuevaConsulta));
    }


}
