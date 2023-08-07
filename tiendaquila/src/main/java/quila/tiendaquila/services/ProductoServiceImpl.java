package quila.tiendaquila.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import quila.tiendaquila.entities.CategoriaEntity;
import quila.tiendaquila.entities.ProductoEntity;
import quila.tiendaquila.repositories.ProductoRepository;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<ProductoEntity> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public ProductoEntity findById(Long productoId) {
        return productoRepository.findById(productoId).get();
    }
    @Override
    public ProductoEntity save(ProductoEntity productoEntity) {
        ProductoEntity nuevoProducto = productoRepository.save(productoEntity);
        return nuevoProducto;
    }

    @Override
    public ResponseEntity<ProductoEntity> modifyProduct(Long productoId, ProductoEntity productoModificado) {
        Boolean existeProducto = productoRepository.existsById(productoId);
        if(existeProducto){
            ProductoEntity productoObjetivo = productoRepository.findById(productoId).get();
            productoObjetivo.setNombreProducto(productoModificado.getNombreProducto());
            productoObjetivo.setDescripcionProducto(productoModificado.getDescripcionProducto());
            productoObjetivo.setEmprendedorId(productoModificado.getEmprendedorId());
            productoObjetivo.setCategoriaId(productoModificado.getCategoriaId());
            return ResponseEntity.ok(productoRepository.save((productoObjetivo)));
        }
        return  ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<String> deleteById(Long productoId) {
        Boolean existeProducto = productoRepository.existsById(productoId);
        if (existeProducto) {
            productoRepository.deleteById(productoId);
            return  ResponseEntity.ok("Producto eliminado correctamente.");
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public List<ProductoEntity> findByCategory(List<CategoriaEntity> listadoCategorias) {
        return  productoRepository.findByCategorias(listadoCategorias);
    }
}
