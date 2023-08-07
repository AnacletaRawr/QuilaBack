package quila.tiendaquila.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quila.tiendaquila.entities.CategoriaEntity;
import quila.tiendaquila.services.CategoriaServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoriaController {

    // Inyección de dependencia desde implementación de Service
    @Autowired
    private CategoriaServiceImpl categoriaService;

    // Solicitudes GET
    @GetMapping(value = "/todas")
    public List<CategoriaEntity> obtenerTodasCategorias(){
        return categoriaService.findAll();
    }

    // Solicitudes POST
    @PostMapping(value = "/nuevo")
    public ResponseEntity<CategoriaEntity> crearCategoria(@RequestBody CategoriaEntity nuevaCategoria){
        return ResponseEntity.ok(categoriaService.save(nuevaCategoria));
    }
    // Solicitudes POST
    @PutMapping(value = "/modificar/{idCategoria}")
    public ResponseEntity<CategoriaEntity> modificarCategoria(@PathVariable Long idCategoria, @RequestBody CategoriaEntity categoriaModificada) {
        return ResponseEntity.ok(categoriaService.modifyById(idCategoria,categoriaModificada));
    }

    // Solicitudes DELETE
    @DeleteMapping(value = "/eliminar/{idCategoria}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable Long idCategoria) {
        return categoriaService.deleteById(idCategoria);
    }

}
