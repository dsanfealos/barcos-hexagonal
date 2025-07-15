package sanfe.spring_ships_hexagonal.application.usecasesimpl;

import sanfe.spring_ships_hexagonal.domain.ports.in.DeleteDockUseCase;
import sanfe.spring_ships_hexagonal.domain.ports.out.DockRepositoryPort;

public class DeleteDockUseCaseImpl implements DeleteDockUseCase {

    private final DockRepositoryPort dockRepositoryPort;

    public DeleteDockUseCaseImpl(DockRepositoryPort dockRepositoryPort) {
        this.dockRepositoryPort = dockRepositoryPort;
    }

    @Override
    public boolean deleteDock(Long id) {
        return dockRepositoryPort.deleteDockById(id);
    }
}
