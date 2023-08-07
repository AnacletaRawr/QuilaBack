package quila.tiendaquila.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import quila.tiendaquila.entities.CategoriaEntity;
import quila.tiendaquila.entities.ProductoEntity;

import java.util.List;

public interface ProductoRepository extends JpaRepository<ProductoEntity,Long> {

    @Query("SELECT p FROM ProductoEntity p WHERE p.categoriaId IN ?1")
    List<ProductoEntity> findByCategorias(List<CategoriaEntity> listadoCategorias);
}
