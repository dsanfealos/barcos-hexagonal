package sanfe.barcos_hexagonal.application.usecasesimpl;

import sanfe.barcos_hexagonal.domain.ports.in.CreateShipUseCase;
import sanfe.barcos_hexagonal.domain.models.Ship;
import sanfe.barcos_hexagonal.domain.ports.out.ShipRepositoryPort;

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
