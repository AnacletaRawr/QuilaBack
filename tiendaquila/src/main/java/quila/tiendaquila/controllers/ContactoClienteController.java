package quila.tiendaquila.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quila.tiendaquila.entities.ContactoClienteEntity;
import quila.tiendaquila.services.ContactoClienteServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/contacto-cliente")
@CrossOrigin("*")
public class ContactoClienteController {

    @Autowired
    ContactoClienteServiceImpl contactoClienteService;

    // solicitudes GET
    @GetMapping(value = "/todos")
    public List<ContactoClienteEntity> verTodo() {
        return contactoClienteService.getAll();
    }
    //Solicitudes POST
    @PostMapping(value = "/registrar")
    public ResponseEntity<ContactoClienteEntity> registrarContacto(@RequestBody ContactoClienteEntity nuevoRegistro) {
        return contactoClienteService.save(nuevoRegistro);
    }

    // Solicitudes PUT

    // Solicitudes DELETE


}
