package sanfe.barcos_hexagonal.domain.ports.in;

import sanfe.barcos_hexagonal.domain.models.Dock;

import java.util.Optional;

public interface UpdateDockUseCase {
    Optional<Dock> updateDock(Dock dock);
}
