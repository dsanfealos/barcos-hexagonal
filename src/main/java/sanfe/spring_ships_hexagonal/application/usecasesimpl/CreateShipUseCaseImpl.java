package sanfe.spring_ships_hexagonal.application.usecasesimpl;

import sanfe.spring_ships_hexagonal.domain.ports.in.CreateShipUseCase;
import sanfe.spring_ships_hexagonal.domain.models.Ship;
import sanfe.spring_ships_hexagonal.domain.ports.out.ShipRepositoryPort;

public class CreateShipUseCaseImpl implements CreateShipUseCase {

    private final ShipRepositoryPort shipRepositoryPort;

    public CreateShipUseCaseImpl(ShipRepositoryPort shipRepositoryPort) {
        this.shipRepositoryPort = shipRepositoryPort;
    }

    @Override
    public Ship createShip(Ship ship) {
        return shipRepositoryPort.save(ship);
    }
}
