package quila.tiendaquila.services;

import org.springframework.http.ResponseEntity;
import quila.tiendaquila.entities.EmprendedorEntity;

import java.util.List;

public interface EmprendedorService {
    List<EmprendedorEntity> findAll();

    EmprendedorEntity findById(Long idEmprendedor);

    ResponseEntity<EmprendedorEntity> modifyById(Long idEmprendedor, EmprendedorEntity modificarEmprendedor);

    ResponseEntity<String> deleteById(Long idEmprendedor);
}
