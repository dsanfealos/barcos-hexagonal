package sanfe.barcos_hexagonal.domain.ports.in;

import sanfe.barcos_hexagonal.domain.models.Ship;

import java.util.Optional;

public interface UpdateShipUseCase {
    Optional<Ship> updateShip(Ship ship);
}
