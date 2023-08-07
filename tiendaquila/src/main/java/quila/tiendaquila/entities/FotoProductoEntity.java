package quila.tiendaquila.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "foto_producto")
public class FotoProductoEntity {
    // Declaración de Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long fotoId;

    // Declaración de foreign Keys
    @ManyToOne
    @JoinColumn(name = "foto_producto")
    private ProductoEntity productoId;

    // Declaración de otros atributos
    private String rutaFoto;

    // constructores

    public FotoProductoEntity(ProductoEntity productoId, String rutaFoto) {
        this.productoId = productoId;
        this.rutaFoto = rutaFoto;
    }

    public FotoProductoEntity() {
    }

    // Getters & Setters


    public Long getFotoId() {
        return fotoId;
    }

    public ProductoEntity getProductoId() {
        return productoId;
    }

    public void setProductoId(ProductoEntity productoId) {
        this.productoId = productoId;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }
}
