package quila.tiendaquila.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import quila.tiendaquila.entities.EmprendedorEntity;
import quila.tiendaquila.repositories.EmprendedorRepository;

import java.util.List;

@Service
public class EmprendedorServiceImpl implements EmprendedorService {
    @Autowired
    EmprendedorRepository emprendedorRepository;

    @Override
    public List<EmprendedorEntity> findAll() {
        return emprendedorRepository.findAll();
    }
    @Override
    public EmprendedorEntity findById(Long idEmprendedor) {
        return  emprendedorRepository.findById(idEmprendedor).get();
    }

    @Override
    public ResponseEntity<EmprendedorEntity> modifyById(Long idEmprendedor, EmprendedorEntity modificarEmprendedor) {
        Boolean existeEmprendedor = emprendedorRepository.existsById(idEmprendedor);
        if(existeEmprendedor){
            EmprendedorEntity emprendedorObjetivo = emprendedorRepository.findById(idEmprendedor).get();
            emprendedorObjetivo.setNombreEmprendedor(modificarEmprendedor.getNombreEmprendedor());
            emprendedorObjetivo.setHistoriaEmprendedor(modificarEmprendedor.getHistoriaEmprendedor());
            emprendedorObjetivo.setHistoriaEmprendedor(modificarEmprendedor.getHistoriaEmprendedor());
            emprendedorObjetivo.setFotoEmprendedor(modificarEmprendedor.getFotoEmprendedor());
            return  ResponseEntity.ok(emprendedorRepository.save(emprendedorObjetivo));
        }
        return  ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<String> deleteById(Long idEmprendedor) {
        Boolean existeEmprendedor = emprendedorRepository.existsById(idEmprendedor);
        if(existeEmprendedor){
            emprendedorRepository.deleteById(idEmprendedor);
            return ResponseEntity.ok("Emprendedor eliminado correctamente.");
        }
        return ResponseEntity.notFound().build();
    }

    public EmprendedorEntity save(EmprendedorEntity nuevoEmprendedor) {
        return  emprendedorRepository.save(nuevoEmprendedor);
    }
}
