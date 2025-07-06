package sanfe.barcos_hexagonal.application.usecasesimpl;

import sanfe.barcos_hexagonal.domain.ports.in.CreateDockUseCase;
import sanfe.barcos_hexagonal.domain.models.Dock;
import sanfe.barcos_hexagonal.domain.ports.out.DockRepositoryPort;

public class CreateDockUseCaseImpl implements CreateDockUseCase {

    private final DockRepositoryPort dockRepositoryPort;

    public CreateDockUseCaseImpl(DockRepositoryPort dockRepositoryPort) {
        this.dockRepositoryPort = dockRepositoryPort;
    }

    @Override
    public Dock createDock(Dock dock) {
        return dockRepositoryPort.save(dock);
    }
}
