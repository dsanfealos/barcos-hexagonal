package sanfe.spring_ships_hexagonal.domain.ports.in;

import sanfe.spring_ships_hexagonal.domain.models.Ship;

import java.util.List;
import java.util.Optional;

public interface RetrieveShipUseCase {
    Optional<Ship> getShip(Long id);
    List<Ship> getAllShips();
}
