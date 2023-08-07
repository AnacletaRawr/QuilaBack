package quila.tiendaquila.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import quila.tiendaquila.entities.ContactoClienteEntity;

public interface ContactoClienteRepository extends JpaRepository<ContactoClienteEntity, Long> {
}
