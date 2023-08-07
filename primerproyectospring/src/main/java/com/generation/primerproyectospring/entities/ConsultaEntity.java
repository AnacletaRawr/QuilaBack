package com.generation.primerproyectospring.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "consultas")
@NoArgsConstructor // constructor vacío
@AllArgsConstructor // Constructor Lleno
@Getter // Getters
@Setter // Setters
public class ConsultaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consultaId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date fechaConsulta;

    private String motivoConsulta;

    @JsonBackReference//Indicamos que consulta pertenece a paciente
    @ManyToOne
    @JoinColumn(name= "registro_id")//Indicamos el nombre de la columna donde está la llave foránea
    private RegistroPacienteEntity pacienteConsulta;

    @JsonIgnore
    @OneToMany(mappedBy = "registro_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ConsultaEntity> consultasProgramadas;


}
