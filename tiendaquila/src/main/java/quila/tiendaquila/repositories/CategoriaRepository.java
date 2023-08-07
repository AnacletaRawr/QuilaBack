package quila.tiendaquila.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import quila.tiendaquila.entities.CategoriaEntity;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
}
