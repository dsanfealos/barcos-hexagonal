package sanfe.barcos_hexagonal.application.usecasesimpl;

import sanfe.barcos_hexagonal.domain.ports.in.RetrieveShipUseCase;
import sanfe.barcos_hexagonal.domain.models.Ship;
import sanfe.barcos_hexagonal.domain.ports.out.ShipRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveShipUseCaseImpl implements RetrieveShipUseCase {

    private final ShipRepositoryPort shipRepositoryPort;

    public RetrieveShipUseCaseImpl(ShipRepositoryPort shipRepositoryPort) {
        this.shipRepositoryPort = shipRepositoryPort;
    }

    @Override
    public Optional<Ship> getShip(Long id) {
        return shipRepositoryPort.findShipById(id);
    }

    @Override
    public List<Ship> getAllShips() {
        return shipRepositoryPort.findAllShips();
    }
}
