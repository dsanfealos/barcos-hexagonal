package sanfe.spring_ships_hexagonal.domain.ports.in;

import sanfe.spring_ships_hexagonal.domain.models.Dock;

import java.util.List;
import java.util.Optional;

public interface RetrieveDockUseCase {
    Optional<Dock> getDock(Long id);
    List<Dock> getAllDocks();
}
