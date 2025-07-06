package sanfe.barcos_hexagonal.domain.ports.in;

import sanfe.barcos_hexagonal.domain.models.Ship;

import java.util.List;
import java.util.Optional;

public interface RetrieveShipUseCase {
    Optional<Ship> getShip(Long id);
    List<Ship> getAllShips();
}
