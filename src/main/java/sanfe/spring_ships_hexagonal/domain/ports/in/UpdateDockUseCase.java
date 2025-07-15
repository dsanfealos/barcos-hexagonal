package sanfe.spring_ships_hexagonal.domain.ports.in;

import sanfe.spring_ships_hexagonal.domain.models.Dock;

import java.util.Optional;

public interface UpdateDockUseCase {
    Optional<Dock> updateDock(Dock dock);
}
