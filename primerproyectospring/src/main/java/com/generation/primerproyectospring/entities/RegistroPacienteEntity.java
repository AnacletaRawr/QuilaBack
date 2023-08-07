package com.generation.primerproyectospring.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "pacientes")
public class RegistroPacienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registroId;

    private String prevision;

    @JsonManagedReference//Indicamos que es la dueña de la relación
    @OneToMany(mappedBy = "pacienteConsulta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ConsultaEntity> consultasPaciente;

    @OneToOne
    private PersonajeEntity pacienteEntity;

    // Fechas de auditoría
    @CreationTimestamp //Indica que el atributo siguiente es una fecha de creación
    private LocalDateTime createdAt;

    @UpdateTimestamp // Indica que el atributo siguiente es una fecha de modificación
    private LocalDateTime updatedAt;

    // Constructores

    public RegistroPacienteEntity(String prevision, PersonajeEntity pacienteEntity) {
        this.prevision = prevision;
        this.pacienteEntity = pacienteEntity;
    }

    public RegistroPacienteEntity() {
    }
    // Getters y setters

    public Long getRegistroId() {
        return registroId;
    }

    public String getPrevision() {
        return prevision;
    }

    public void setPrevision(String prevision) {
        this.prevision = prevision;
    }

    public PersonajeEntity getPacienteEntity() {
        return pacienteEntity;
    }

    public void setPacienteEntity(PersonajeEntity pacienteEntity) {
        this.pacienteEntity = pacienteEntity;
    }


}
