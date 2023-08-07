package quila.tiendaquila.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import quila.tiendaquila.entities.EmprendedorEntity;

public interface EmprendedorRepository extends JpaRepository<EmprendedorEntity, Long> {
}
