package com.generation.primerproyectospring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "doctor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DoctorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;

    private String doctorNombre;

    @JsonIgnore //Permite solucionar la recursividad, ignorando esta entidad cuando consultemos por la otra, que es la mandatoria
    @ManyToMany
    @JoinTable(//permite crear una tabla relacional que recibe tres argumentos
            // Argumento 1: nombre de la ttabla relacional
            name = "doctor_especialidad",
            // Nombre de la columna que lleva la llave foránea, dentro de la otra tabla
            joinColumns = @JoinColumn(name = "doctor_id"),
            // Nombre de la columna que lleva la llave foránea de la otra entidad en esta tabla
            inverseJoinColumns = @JoinColumn(name = "especialidad_id")
    )
    private List<DoctorEntity> doctoresEspecialidad;


}
