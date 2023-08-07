package quila.tiendaquila.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "emprendedor")
public class EmprendedorEntity {

    // Declaración de Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long emprendedorId;
    // Declaración de foreign Keys

    // Declaración de otros atributos
    private String nombreEmprendedor;
    private String nombreEmprendimiento;
    private String historiaEmprendedor;
    private String fotoEmprendedor;

    // constructores


    public EmprendedorEntity(String nombreEmprendedor, String nombreEmprendimiento, String historiaEmprendedor, String fotoEmprendedor) {
        this.nombreEmprendedor = nombreEmprendedor;
        this.nombreEmprendimiento = nombreEmprendimiento;
        this.historiaEmprendedor = historiaEmprendedor;
        this.fotoEmprendedor = fotoEmprendedor;
    }

    public EmprendedorEntity() {
    }

    // Getters & Setters


    public Long getEmprendedorId() {
        return emprendedorId;
    }

    public String getNombreEmprendedor() {
        return nombreEmprendedor;
    }

    public void setNombreEmprendedor(String nombreEmprendedor) {
        this.nombreEmprendedor = nombreEmprendedor;
    }

    public String getNombreEmprendimiento() {
        return nombreEmprendimiento;
    }

    public void setNombreEmprendimiento(String nombreEmprendimiento) {
        this.nombreEmprendimiento = nombreEmprendimiento;
    }

    public String getHistoriaEmprendedor() {
        return historiaEmprendedor;
    }

    public void setHistoriaEmprendedor(String historiaEmprendedor) {
        this.historiaEmprendedor = historiaEmprendedor;
    }

    public String getFotoEmprendedor() {
        return fotoEmprendedor;
    }

    public void setFotoEmprendedor(String fotoEmprendedor) {
        this.fotoEmprendedor = fotoEmprendedor;
    }
}
