package com.generation.primerproyectospring.services;


import com.generation.primerproyectospring.entities.RegistroPacienteEntity;
import com.generation.primerproyectospring.repositories.RegistroPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroPacienteServiceImpl implements RegistroPacienteService {
    // Esta clase, al no ser abstracta, debe implementar métodos

    // Primero, se debe vincular con el repository de nuestro objeto
    @Autowired
    RegistroPacienteRepository registroPacienteRepository;
    @Override
    public List<RegistroPacienteEntity> obtenerPacientesRegistrados(){
        List<RegistroPacienteEntity> listaDePacientes = registroPacienteRepository.findAll();
        return  listaDePacientes;
    }

    @Override
    public RegistroPacienteEntity crearNuevoRegistro(RegistroPacienteEntity nuevoPaciente) {
        RegistroPacienteEntity registroNuevo = registroPacienteRepository.save(nuevoPaciente);
        return registroNuevo;
    }

    @Override
    public RegistroPacienteEntity buscarPacientePorId(Long id) {
        return registroPacienteRepository.findById(id).get();
    }

}
