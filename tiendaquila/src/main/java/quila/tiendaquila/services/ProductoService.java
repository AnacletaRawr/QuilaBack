package quila.tiendaquila.services;

import org.springframework.http.ResponseEntity;
import quila.tiendaquila.entities.CategoriaEntity;
import quila.tiendaquila.entities.ProductoEntity;

import java.util.List;

public interface ProductoService {
    List<ProductoEntity> findAll();

    ProductoEntity findById(Long productoId);

    ProductoEntity save(ProductoEntity productoEntity);

    Object modifyProduct(Long productoId, ProductoEntity productoModificado);

    ResponseEntity<String> deleteById(Long productoId);

    List<ProductoEntity> findByCategory(List<CategoriaEntity> listadoCategorias);
}
