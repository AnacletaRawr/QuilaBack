package quila.tiendaquila.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import quila.tiendaquila.entities.ActividadesEntity;

public interface ActividadesRepository extends JpaRepository<ActividadesEntity, Long> {
}
