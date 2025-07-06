package sanfe.barcos_hexagonal.domain.ports.out;

import sanfe.barcos_hexagonal.domain.models.Ship;

import java.util.List;
import java.util.Optional;

public interface ShipRepositoryPort {
    Ship save(Ship ship);
    boolean deleteShipById(Long id);
    Optional<Ship> findShipById(Long id);
    List<Ship> findAllShips();
    Optional<Ship> update(Ship ship);
}
