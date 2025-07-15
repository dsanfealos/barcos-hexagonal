package sanfe.spring_ships_hexagonal.application.usecasesimpl;

import sanfe.spring_ships_hexagonal.domain.ports.in.UpdateShipUseCase;
import sanfe.spring_ships_hexagonal.domain.models.Ship;
import sanfe.spring_ships_hexagonal.domain.ports.out.ShipRepositoryPort;

import java.util.Optional;

public class UpdateShipUseCaseImpl implements UpdateShipUseCase {

    private final ShipRepositoryPort shipRepositoryPort;

    public UpdateShipUseCaseImpl(ShipRepositoryPort shipRepositoryPort) {
        this.shipRepositoryPort = shipRepositoryPort;
    }

    @Override
    public Optional<Ship> updateShip(Ship ship) {
        return shipRepositoryPort.update(ship);
    }
}
