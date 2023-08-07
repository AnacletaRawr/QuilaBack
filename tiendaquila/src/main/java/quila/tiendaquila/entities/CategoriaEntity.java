package quila.tiendaquila.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categoria_producto")
public class CategoriaEntity {
    // Declaración de Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long categoriaProductoId;
    // Declaración de Foreign Keys

    @OneToMany
    @JoinColumn(name = "categoria_id")
    private List<ProductoEntity> productos;
    // Declaración de otros atributos
    private String nombreCategoria;
    private String fotoCategoria;

    // Constructores

    public CategoriaEntity(String nombreCategoria, String fotoCategoria) {
        this.nombreCategoria = nombreCategoria;
        this.fotoCategoria = fotoCategoria;
    }

    public CategoriaEntity() {
    }

    // Getters & setters


    public Long getCategoriaProductoId() {
        return categoriaProductoId;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getFotoCategoria() {
        return fotoCategoria;
    }

    public void setFotoCategoria(String fotoCategoria) {
        this.fotoCategoria = fotoCategoria;
    }
}
