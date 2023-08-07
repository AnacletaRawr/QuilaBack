package quila.tiendaquila.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quila.tiendaquila.entities.EmprendedorEntity;
import quila.tiendaquila.services.EmprendedorServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/emprendedores")
@CrossOrigin
public class EmprendedorController {

    @Autowired
    EmprendedorServiceImpl emprendedorService;

    // solicitudes GET

    @GetMapping("/mensaje")
    public String mensaje() {
        return "hola desde spring rest";
    }

    @GetMapping(value = "/todos")
    public List<EmprendedorEntity> obtenerEmprendedores() {
        return emprendedorService.findAll();
    }

    @GetMapping(value = "/emprendedor/{idEmprendedor}")
    public  EmprendedorEntity obtenerEmprendedor(@PathVariable Long idEmprendedor) {
        return emprendedorService.findById(idEmprendedor);
    }

    // Solicitudes POST

    @PostMapping(value = "/nuevo")
    public  EmprendedorEntity nuevoEmprendedor(@RequestBody EmprendedorEntity nuevoEmprendedor) {
        return emprendedorService.save(nuevoEmprendedor);
    }

    // Solicitudes PUT

    @PutMapping(value = "/editar/{idEmprendedor}")
    public ResponseEntity<EmprendedorEntity> modificarEmprendedor(@PathVariable Long idEmprendedor, @RequestBody EmprendedorEntity modificarEmprendedor) {
        return emprendedorService.modifyById(idEmprendedor,modificarEmprendedor);
    }

    // Solicitudes DELETE
    @DeleteMapping(value = "/eliminar/{idEmprendedor}")
    public ResponseEntity<String> eliminarEmprendedor(@PathVariable Long idEmprendedor) {
        return emprendedorService.deleteById(idEmprendedor);
    }

}
