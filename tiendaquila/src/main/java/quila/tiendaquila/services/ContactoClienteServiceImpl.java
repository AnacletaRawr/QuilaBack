package quila.tiendaquila.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import quila.tiendaquila.entities.ContactoClienteEntity;
import quila.tiendaquila.repositories.ContactoClienteRepository;

import java.util.List;

@Service
public class ContactoClienteServiceImpl implements ContactoClienteService{
    @Autowired
    ContactoClienteRepository contactoClienteRepository;

    @Override
    public ResponseEntity<ContactoClienteEntity> save(ContactoClienteEntity nuevoRegistro) {
        return ResponseEntity.ok(contactoClienteRepository.save(nuevoRegistro));
    }

    @Override
    public List<ContactoClienteEntity> getAll() {
        return  contactoClienteRepository.findAll();
    }
}
