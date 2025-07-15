package sanfe.spring_ships_hexagonal.application.usecasesimpl;

import sanfe.spring_ships_hexagonal.domain.ports.in.UpdateDockUseCase;
import sanfe.spring_ships_hexagonal.domain.models.Dock;
import sanfe.spring_ships_hexagonal.domain.ports.out.DockRepositoryPort;

import java.util.Optional;

public class UpdateDockUseCaseImpl implements UpdateDockUseCase {

    private final DockRepositoryPort dockRepositoryPort;

    public UpdateDockUseCaseImpl(DockRepositoryPort dockRepositoryPort) {
        this.dockRepositoryPort = dockRepositoryPort;
    }

    @Override
    public Optional<Dock> updateDock(Dock dock) {
        return dockRepositoryPort.update(dock);
    }
}
