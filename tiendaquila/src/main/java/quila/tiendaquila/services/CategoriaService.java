package quila.tiendaquila.services;

import org.springframework.http.ResponseEntity;
import quila.tiendaquila.entities.CategoriaEntity;

import java.util.List;

public interface CategoriaService {
    List<CategoriaEntity> findAll();

    CategoriaEntity save(CategoriaEntity nuevaCategoria);

    Object modifyById(Long idCategoria, CategoriaEntity categoriaModificada);

    ResponseEntity<String> deleteById(Long idCategoria);
}
