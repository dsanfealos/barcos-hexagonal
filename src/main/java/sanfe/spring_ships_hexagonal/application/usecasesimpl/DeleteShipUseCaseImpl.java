package sanfe.spring_ships_hexagonal.application.usecasesimpl;

import sanfe.spring_ships_hexagonal.domain.ports.in.DeleteShipUseCase;
import sanfe.spring_ships_hexagonal.domain.ports.out.ShipRepositoryPort;

public class DeleteShipUseCaseImpl implements DeleteShipUseCase {

    private final ShipRepositoryPort shipRepositoryPort;

    public DeleteShipUseCaseImpl(ShipRepositoryPort shipRepositoryPort) {
        this.shipRepositoryPort = shipRepositoryPort;
    }

    @Override
    public boolean deleteShip(Long id) {
        return shipRepositoryPort.deleteShipById(id);
    }
}
