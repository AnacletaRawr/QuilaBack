package quila.tiendaquila.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity //Esta anotación indica que la clase declarada corresponde a una entidad de la BD
@Table(name = "producto") //Esta anotación indica que la clase declarada está asociada a una tabla de la BD
public class ProductoEntity {
    // Declaración de atributo id, no nulo y único
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long productoId;

    // Declaración de llaves foráneas

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaEntity categoriaId;
    @ManyToOne
    @JoinColumn(name = "emprendedor_id")
    private EmprendedorEntity emprendedorId;

    // Declaración de otros atributos correspondientes a columnas
    private String nombreProducto;
    private String descripcionProducto;

    @OneToMany
    @JoinColumn(name = "producto_id")
    private List<FotoProductoEntity> fotoProducto;

    // Constructores


    public ProductoEntity(CategoriaEntity categoriaId, EmprendedorEntity emprendedorId, String nombreProducto, String descripcionProducto, List<FotoProductoEntity> fotoProducto) {
        this.categoriaId = categoriaId;
        this.emprendedorId = emprendedorId;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.fotoProducto = fotoProducto;
    }

    public ProductoEntity() {
    }

    // Getters y setters

    public List<FotoProductoEntity> getFotoProducto() {
        return fotoProducto;
    }

    public void setFotoProducto(List<FotoProductoEntity> fotoProducto) {
        this.fotoProducto = fotoProducto;
    }

    public Long getProductoId() {
        return productoId;
    }

    public CategoriaEntity getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(CategoriaEntity categoriaId) {
        this.categoriaId = categoriaId;
    }

    public EmprendedorEntity getEmprendedorId() {
        return emprendedorId;
    }

    public void setEmprendedorId(EmprendedorEntity emprendedorId) {
        this.emprendedorId = emprendedorId;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

}
