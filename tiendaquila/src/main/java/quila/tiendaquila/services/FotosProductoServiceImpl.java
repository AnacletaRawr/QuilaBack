package quila.tiendaquila.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import quila.tiendaquila.entities.FotoProductoEntity;
import quila.tiendaquila.repositories.FotoProductoRepository;

import java.util.List;

@Service
public class FotosProductoServiceImpl implements FotosProductoService {

    @Autowired
    FotoProductoRepository fotoProductoRepository;

    @Override
    public ResponseEntity<FotoProductoEntity> save(FotoProductoEntity nuevaFoto) {
        return ResponseEntity.ok(fotoProductoRepository.save(nuevaFoto));
    }

    @Override
    public ResponseEntity<String> deleteById(Long idFoto) {
        Boolean existeFoto = fotoProductoRepository.existsById(idFoto);
        if(existeFoto) {
            fotoProductoRepository.deleteById(idFoto);
            return ResponseEntity.ok("Foto de producto eliminada correctamente.");
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<FotoProductoEntity> modifyFotoProducto(Long idFoto, FotoProductoEntity modificarFoto) {
        Boolean existeFoto = fotoProductoRepository.existsById(idFoto);
        if(existeFoto) {
            FotoProductoEntity fotoObjetivo = fotoProductoRepository.findById(idFoto).get();
            fotoObjetivo.setRutaFoto(modificarFoto.getRutaFoto());
            return ResponseEntity.ok(fotoProductoRepository.save(fotoObjetivo));
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public List<FotoProductoEntity> findAll() {
        return  fotoProductoRepository.findAll();
    }
}
