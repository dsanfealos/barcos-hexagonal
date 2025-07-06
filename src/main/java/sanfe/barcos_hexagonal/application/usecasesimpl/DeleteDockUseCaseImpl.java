package sanfe.barcos_hexagonal.application.usecasesimpl;

import sanfe.barcos_hexagonal.domain.ports.in.DeleteDockUseCase;
import sanfe.barcos_hexagonal.domain.ports.out.DockRepositoryPort;

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
