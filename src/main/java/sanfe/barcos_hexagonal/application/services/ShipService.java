package sanfe.barcos_hexagonal.application.services;

import sanfe.barcos_hexagonal.domain.ports.in.CreateShipUseCase;
import sanfe.barcos_hexagonal.domain.ports.in.DeleteShipUseCase;
import sanfe.barcos_hexagonal.domain.ports.in.RetrieveShipUseCase;
import sanfe.barcos_hexagonal.domain.ports.in.UpdateShipUseCase;
import sanfe.barcos_hexagonal.domain.models.Ship;

import java.util.List;
import java.util.Optional;

public class ShipService implements CreateShipUseCase, DeleteShipUseCase, UpdateShipUseCase, RetrieveShipUseCase {

    private final CreateShipUseCase createShipUseCase;
    private final DeleteShipUseCase deleteShipUseCase;
    private final UpdateShipUseCase updateShipUseCase;
    private final RetrieveShipUseCase retrieveShipUseCase;

    public ShipService(CreateShipUseCase createShipUseCase, DeleteShipUseCase deleteShipUseCase, UpdateShipUseCase updateShipUseCase, RetrieveShipUseCase retrieveShipUseCase) {
        this.createShipUseCase = createShipUseCase;
        this.deleteShipUseCase = deleteShipUseCase;
        this.updateShipUseCase = updateShipUseCase;
        this.retrieveShipUseCase = retrieveShipUseCase;
    }

    @Override
    public Ship createShip(Ship ship) {
        return createShipUseCase.createShip(ship);
    }

    @Override
    public boolean deleteShip(Long id) {
        return deleteShipUseCase.deleteShip(id);
    }

    @Override
    public Optional<Ship> getShip(Long id) {
        return retrieveShipUseCase.getShip(id);
    }

    @Override
    public List<Ship> getAllShips() {
        return retrieveShipUseCase.getAllShips();
    }

    @Override
    public Optional<Ship> updateShip(Ship ship) {
        return updateShipUseCase.updateShip(ship);
    }
}
