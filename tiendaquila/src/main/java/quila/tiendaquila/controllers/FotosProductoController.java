package quila.tiendaquila.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quila.tiendaquila.entities.FotoProductoEntity;
import quila.tiendaquila.entities.ProductoEntity;
import quila.tiendaquila.services.FotosProductoServiceImpl;
import quila.tiendaquila.services.ProductoServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/foto-producto")
@CrossOrigin("*")
public class FotosProductoController {
    @Autowired
    FotosProductoServiceImpl fotosProductoService;

    @Autowired
    ProductoServiceImpl productoService;

    // solicitudes GET

    @GetMapping(value = "/todos")
    public List<FotoProductoEntity> obtenerfotos() {
        return fotosProductoService.findAll();
    }

    // Solicitudes POST
    @PostMapping(value = "/nueva/{idProducto}")
    public ResponseEntity<FotoProductoEntity> agregarFotoPorIdProducto(@PathVariable Long idProducto,
                                                                       @RequestBody FotoProductoEntity nuevaFoto) {
        ProductoEntity productoElegido = productoService.findById(idProducto);
        nuevaFoto.setProductoId(productoElegido);
        return fotosProductoService.save(nuevaFoto);
    }
    // Solicitudes PUT
    @PutMapping(value = "/modificar/{idFoto}")
    public ResponseEntity<FotoProductoEntity> modificarFotoProducto(@PathVariable Long idFoto, @RequestBody FotoProductoEntity modificarFoto) {
        return  fotosProductoService.modifyFotoProducto(idFoto,modificarFoto);
    }


    // Solicitudes DELETE
    @DeleteMapping(value = "/eliminar/{idFoto}")
    public ResponseEntity<String> eliminarFoto(@PathVariable Long idFoto) {
        return fotosProductoService.deleteById(idFoto);
    }


}
