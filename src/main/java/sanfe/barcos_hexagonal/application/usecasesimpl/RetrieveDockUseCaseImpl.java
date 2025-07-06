package sanfe.barcos_hexagonal.application.usecasesimpl;

import sanfe.barcos_hexagonal.domain.ports.in.RetrieveDockUseCase;
import sanfe.barcos_hexagonal.domain.models.Dock;
import sanfe.barcos_hexagonal.domain.ports.out.DockRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveDockUseCaseImpl implements RetrieveDockUseCase {

    private final DockRepositoryPort dockRepositoryPort;

    public RetrieveDockUseCaseImpl(DockRepositoryPort dockRepositoryPort) {
        this.dockRepositoryPort = dockRepositoryPort;
    }

    @Override
    public Optional<Dock> getDock(Long id) {
        return dockRepositoryPort.findDockById(id);
    }

    @Override
    public List<Dock> getAllDocks() {
        return dockRepositoryPort.findAllDocks();
    }
}
