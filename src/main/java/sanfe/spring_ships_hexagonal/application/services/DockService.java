package sanfe.spring_ships_hexagonal.application.services;

import sanfe.spring_ships_hexagonal.domain.ports.in.CreateDockUseCase;
import sanfe.spring_ships_hexagonal.domain.ports.in.DeleteDockUseCase;
import sanfe.spring_ships_hexagonal.domain.ports.in.RetrieveDockUseCase;
import sanfe.spring_ships_hexagonal.domain.ports.in.UpdateDockUseCase;
import sanfe.spring_ships_hexagonal.domain.models.Dock;

import java.util.List;
import java.util.Optional;

public class DockService implements CreateDockUseCase, DeleteDockUseCase, UpdateDockUseCase, RetrieveDockUseCase {

    private final CreateDockUseCase createDockUseCase;
    private final DeleteDockUseCase deleteDockUseCase;
    private final UpdateDockUseCase updateDockUseCase;
    private final RetrieveDockUseCase retrieveDockUseCase;

    public DockService(CreateDockUseCase createDockUseCase, DeleteDockUseCase deleteDockUseCase, UpdateDockUseCase updateDockUseCase, RetrieveDockUseCase retrieveDockUseCase) {
        this.createDockUseCase = createDockUseCase;
        this.deleteDockUseCase = deleteDockUseCase;
        this.updateDockUseCase = updateDockUseCase;
        this.retrieveDockUseCase = retrieveDockUseCase;
    }

    @Override
    public Dock createDock(Dock dock) {
        return createDockUseCase.createDock(dock);
    }

    @Override
    public boolean deleteDock(Long id) {
        return deleteDockUseCase.deleteDock(id);
    }

    @Override
    public Optional<Dock> getDock(Long id) {
        return retrieveDockUseCase.getDock(id);
    }

    @Override
    public List<Dock> getAllDocks() {
        return retrieveDockUseCase.getAllDocks();
    }

    @Override
    public Optional<Dock> updateDock(Dock dock) {
        return updateDockUseCase.updateDock(dock);
    }
}
