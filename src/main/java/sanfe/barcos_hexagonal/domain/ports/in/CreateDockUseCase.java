package sanfe.barcos_hexagonal.domain.ports.in;

import sanfe.barcos_hexagonal.domain.models.Dock;

public interface CreateDockUseCase {
    //This is an IN PORT because this makes the application obey an input command
    Dock createDock(Dock dock);
}
