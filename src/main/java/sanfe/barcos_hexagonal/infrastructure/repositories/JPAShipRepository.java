package sanfe.barcos_hexagonal.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sanfe.barcos_hexagonal.infrastructure.entities.ShipEntity;

public interface JPAShipRepository extends JpaRepository<ShipEntity, Long> {
}
