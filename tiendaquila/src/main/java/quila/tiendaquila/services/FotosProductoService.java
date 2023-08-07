package quila.tiendaquila.services;

import org.springframework.http.ResponseEntity;
import quila.tiendaquila.entities.FotoProductoEntity;

import java.util.List;

public interface FotosProductoService {
    ResponseEntity<FotoProductoEntity> save(FotoProductoEntity nuevaFoto);

    ResponseEntity<String> deleteById(Long idfoto);

    ResponseEntity<FotoProductoEntity> modifyFotoProducto(Long idFoto, FotoProductoEntity modificarFoto);

    List<FotoProductoEntity> findAll();
}
