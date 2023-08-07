package com.generation.primerproyectospring.services;

import com.generation.primerproyectospring.entities.RegistroPacienteEntity;

import java.util.List;


// En esta clase sólo se declaran los métodos, los cuales son definidos en el implementador de Service
public interface RegistroPacienteService {

    // Este método va a traer una lista de todos los pacientes registrados
    List<RegistroPacienteEntity> obtenerPacientesRegistrados();

    RegistroPacienteEntity crearNuevoRegistro(RegistroPacienteEntity nuevoPaciente);

    RegistroPacienteEntity buscarPacientePorId(Long id);
}
