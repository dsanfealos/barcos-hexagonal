package sanfe.spring_ships_hexagonal.domain.ports.in;

public interface DeleteShipUseCase {
    boolean deleteShip(Long id);
}
