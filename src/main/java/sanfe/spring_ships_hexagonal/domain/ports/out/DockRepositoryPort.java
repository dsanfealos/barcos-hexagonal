package sanfe.spring_ships_hexagonal.domain.ports.out;

import sanfe.spring_ships_hexagonal.domain.models.Dock;

import java.util.List;
import java.util.Optional;

public interface DockRepositoryPort {
    //This is a OUT PORT because it makes the application look out for resources.
    Dock save(Dock dock);
    boolean deleteDockById(Long id);
    Optional<Dock> findDockById(Long id);
    List<Dock> findAllDocks();
    Optional<Dock> update(Dock dock);
}
