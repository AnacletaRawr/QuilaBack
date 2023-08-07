package quila.tiendaquila.services;

import org.springframework.http.ResponseEntity;
import quila.tiendaquila.entities.ActividadesEntity;
import quila.tiendaquila.entities.EmprendedorEntity;

import java.util.List;

public interface ActividadesService {
    List<ActividadesEntity> findAll();

    ActividadesEntity findById(Long idActividad);

    ResponseEntity<ActividadesEntity> save(ActividadesEntity nuevaActividad);

    ResponseEntity<ActividadesEntity> modifyById(Long idActividad, ActividadesEntity modificarActividad);
}
