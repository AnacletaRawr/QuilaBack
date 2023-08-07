package quila.tiendaquila.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quila.tiendaquila.entities.ActividadesEntity;
import quila.tiendaquila.entities.EmprendedorEntity;
import quila.tiendaquila.services.ActividadesService;
import quila.tiendaquila.services.ActividadesServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/actividades")
@CrossOrigin("*")
public class ActividadesController {

    @Autowired
    ActividadesServiceImpl actividadesService;


    // Solicitudes GET
    @GetMapping(value = "/todo")
    public List<ActividadesEntity> obtenerActividades() {
        return actividadesService.findAll();
    }

    @GetMapping(value = "/actividad/{idActividad}")
    public ActividadesEntity obtenerActividad(@PathVariable Long idActividad) {
        return  actividadesService.findById(idActividad);
    }

    // solicitudes POST

    @PostMapping(value = "/nuevo")
    public ResponseEntity<ActividadesEntity> crearActividad(@RequestBody ActividadesEntity nuevaActividad) {
        return actividadesService.save(nuevaActividad);
    }

    // Solicitudes PUT

    @PutMapping(value = "/modificar/{idActividad}")
    public ResponseEntity<ActividadesEntity> modificarActividad(@PathVariable Long idActividad, @RequestBody ActividadesEntity modificarActividad) {
        return  actividadesService.modifyById(idActividad,modificarActividad);
    }

    // Solicitudes DELETE

    @DeleteMapping(value = "/eliminar/{idActividad}")
    public ResponseEntity<String> eliminarActividad(@PathVariable Long idActividad) {
        return actividadesService.deleteById(idActividad);
    }


}
