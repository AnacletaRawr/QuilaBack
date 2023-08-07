package quila.tiendaquila.services;

import org.springframework.http.ResponseEntity;
import quila.tiendaquila.entities.ContactoClienteEntity;

import java.util.List;

public interface ContactoClienteService {
    ResponseEntity<ContactoClienteEntity> save(ContactoClienteEntity nuevoRegistro);

    List<ContactoClienteEntity> getAll();
}
