package quila.tiendaquila.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import quila.tiendaquila.entities.ActividadesEntity;
import quila.tiendaquila.repositories.ActividadesRepository;

import java.util.List;

@Service
public class ActividadesServiceImpl implements ActividadesService{

    @Autowired
    ActividadesRepository actividadesRepository;

    @Override
    public List<ActividadesEntity> findAll() {
        return actividadesRepository.findAll();
    }

    @Override
    public ActividadesEntity findById(Long idActividad) {
        return  actividadesRepository.findById(idActividad).get();
    }

    @Override
    public ResponseEntity<ActividadesEntity> save(ActividadesEntity nuevaActividad) {
        return  ResponseEntity.ok(actividadesRepository.save(nuevaActividad));
    }

    @Override
    public ResponseEntity<ActividadesEntity> modifyById(Long idActividad, ActividadesEntity modificarActividad) {
        Boolean existeActividad = actividadesRepository.existsById(idActividad);
        if (existeActividad) {
            ActividadesEntity actividadObjetivo = actividadesRepository.findById(idActividad).get();
            actividadObjetivo.setTitularNoticia(modificarActividad.getTitularNoticia());
            actividadObjetivo.setBajadaNoticia(modificarActividad.getBajadaNoticia());
            actividadObjetivo.setCuerpoNoticia(modificarActividad.getCuerpoNoticia());

            actividadObjetivo.setImagenNoticia(modificarActividad.getImagenNoticia());
            return  ResponseEntity.ok(actividadesRepository.save(actividadObjetivo));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<String> deleteById(Long idActividad) {
        Boolean existeActividad = actividadesRepository.existsById(idActividad);
        if (existeActividad) {
            actividadesRepository.deleteById(idActividad);
            return ResponseEntity.ok("Actividad eliminada correctamente.");
        }
        return ResponseEntity.notFound().build();
    }
}
