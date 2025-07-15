package sanfe.spring_ships_hexagonal.domain.ports.in;

import sanfe.spring_ships_hexagonal.domain.models.Ship;

import java.util.Optional;

public interface UpdateShipUseCase {
    Optional<Ship> updateShip(Ship ship);
}
