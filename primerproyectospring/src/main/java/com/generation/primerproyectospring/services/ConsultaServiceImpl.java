package com.generation.primerproyectospring.services;

import com.generation.primerproyectospring.entities.ConsultaEntity;
import com.generation.primerproyectospring.entities.RegistroPacienteEntity;
import com.generation.primerproyectospring.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service//Con esto indicamos a Spring que estamos trabajando con un service
public class ConsultaServiceImpl implements ConsultaService{

    @Autowired//Inyección de dependencia del repository
    private ConsultaRepository consultaRepository;

    @Override
    public ConsultaEntity crearNuevaConsulta(ConsultaEntity nuevaConsulta) {
        ConsultaEntity consultaAgendar = consultaRepository.save(nuevaConsulta);
        return consultaAgendar;
    }
}
