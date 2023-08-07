package com.generation.primerproyectospring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Entity
@Table(name = "especialidades")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EspecialidadesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long especialidadId;

    private String nombreEspecialidad;


    @ManyToMany
    @JoinTable(
            name = "doctores_especialidades",
            joinColumns = @JoinColumn(name = "especialidad_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    private List<DoctorEntity> doctoresEspecialidades;
}
