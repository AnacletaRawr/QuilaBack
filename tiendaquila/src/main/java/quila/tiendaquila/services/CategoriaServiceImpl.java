package quila.tiendaquila.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import quila.tiendaquila.entities.CategoriaEntity;
import quila.tiendaquila.repositories.CategoriaRepository;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    // Inyección de dependencia desde Repository
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaEntity> findAll() {
        return  categoriaRepository.findAll();
    }

    @Override
    public CategoriaEntity save(CategoriaEntity nuevaCategoria){
        return categoriaRepository.save(nuevaCategoria);
    }


    @Override
    public CategoriaEntity modifyById(Long idCategoria, CategoriaEntity categoriaModificada) {
        Boolean existeCategoria = categoriaRepository.existsById(idCategoria);
        if (existeCategoria) {
            CategoriaEntity categoriaObjetivo = categoriaRepository.findById(idCategoria).get();
            categoriaObjetivo.setNombreCategoria(categoriaModificada.getNombreCategoria());
            categoriaObjetivo.setFotoCategoria(categoriaModificada.getFotoCategoria());
            return  categoriaRepository.save(categoriaObjetivo);
        }
        return null;
    }

    @Override
    public ResponseEntity<String> deleteById(Long idCategoria) {
        Boolean existeCategoria = categoriaRepository.existsById(idCategoria);
        if (existeCategoria) {
            categoriaRepository.deleteById(idCategoria);
            return  ResponseEntity.ok("Categoría eliminada correctamente.");
        }
        return ResponseEntity.notFound().build();
    }
}
