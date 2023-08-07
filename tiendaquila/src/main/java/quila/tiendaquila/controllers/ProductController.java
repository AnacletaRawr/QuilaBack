package quila.tiendaquila.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quila.tiendaquila.entities.CategoriaEntity;
import quila.tiendaquila.entities.ProductoEntity;
import quila.tiendaquila.services.ProductoServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    ProductoServiceImpl productoService;

    // Solicitudes GET
    @GetMapping(value="/productos")
    public List<ProductoEntity> findProducts() {
        return productoService.findAll();
    }

    @GetMapping(value = "/producto/{productoId}")
    public ProductoEntity findProduct(@PathVariable Long productoId) {
        return productoService.findById(productoId);
    }

    @GetMapping(value = "/filtrar")
    public List<ProductoEntity> filtrarPorCategoria(@RequestBody List<CategoriaEntity> listadoCategorias) {
        return  productoService.findByCategory(listadoCategorias);
    }

    // Solicitudes POST

    @PostMapping(value ="/nuevoproducto")
    public ResponseEntity<ProductoEntity> nuevoProducto(@RequestBody ProductoEntity productoEntity) {
        return ResponseEntity.ok(productoService.save(productoEntity));
    }

    // solicitudes PUT
    @PutMapping(value = "/modificar-producto/{productoId}")
    public ResponseEntity<ProductoEntity> modificarProducto(@PathVariable Long productoId,
                                                            @RequestBody ProductoEntity productoModificado) {
        return productoService.modifyProduct(productoId,productoModificado);
    }

    // solicitudes DELETE
    @DeleteMapping(value = "/eliminar/{productoId}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Long productoId){
        return productoService.deleteById(productoId);
    }

}
