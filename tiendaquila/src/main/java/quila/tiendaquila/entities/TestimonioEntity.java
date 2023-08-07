package quila.tiendaquila.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "testimonio_emprendedor")
public class TestimonioEntity {
    // Declaración de Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long testimonioId;
    // Declaración de foreign Keys

    @OneToOne
    @JoinColumn(name = "emprendedor_id")
    private EmprendedorEntity emprendedorId;

    // Declaración de otros atributos
    private String contenidoTestimonio;
    // constructores

    public TestimonioEntity(EmprendedorEntity emprendedorId, String contenidoTestimonio) {
        this.emprendedorId = emprendedorId;
        this.contenidoTestimonio = contenidoTestimonio;
    }

    public TestimonioEntity() {
    }

    // Getters & Setters

    public Long getTestimonioId() {
        return testimonioId;
    }


    public EmprendedorEntity getEmprendedorId() {
        return emprendedorId;
    }

    public void setEmprendedorId(EmprendedorEntity emprendedorId) {
        this.emprendedorId = emprendedorId;
    }

    public String getContenidoTestimonio() {
        return contenidoTestimonio;
    }

    public void setContenidoTestimonio(String contenidoTestimonio) {
        this.contenidoTestimonio = contenidoTestimonio;
    }
}
