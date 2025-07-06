package sanfe.barcos_hexagonal.domain.ports.in;

import sanfe.barcos_hexagonal.domain.models.Ship;

public interface CreateShipUseCase {
    Ship createShip(Ship ship);
}
