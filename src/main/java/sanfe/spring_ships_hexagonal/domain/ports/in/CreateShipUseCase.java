package sanfe.spring_ships_hexagonal.domain.ports.in;

import sanfe.spring_ships_hexagonal.domain.models.Ship;

public interface CreateShipUseCase {
    Ship createShip(Ship ship);
}
