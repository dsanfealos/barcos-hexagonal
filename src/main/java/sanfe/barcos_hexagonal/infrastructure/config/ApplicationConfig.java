package sanfe.barcos_hexagonal.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sanfe.barcos_hexagonal.application.services.DockService;
import sanfe.barcos_hexagonal.application.services.ShipService;
import sanfe.barcos_hexagonal.application.usecasesimpl.*;
import sanfe.barcos_hexagonal.domain.ports.out.DockRepositoryPort;
import sanfe.barcos_hexagonal.domain.ports.out.ShipRepositoryPort;
import sanfe.barcos_hexagonal.infrastructure.adapters.JPARepositoryAdapter;

@Configuration
public class ApplicationConfig {

    @Bean
    public DockService dockService(DockRepositoryPort dockRepositoryPort){
        return new DockService(
                new CreateDockUseCaseImpl(dockRepositoryPort),
                new DeleteDockUseCaseImpl(dockRepositoryPort),
                new UpdateDockUseCaseImpl(dockRepositoryPort),
                new RetrieveDockUseCaseImpl(dockRepositoryPort)
        );
    }

    @Bean
    public ShipService shipService(ShipRepositoryPort shipRepositoryPort){
        return new ShipService(
                new CreateShipUseCaseImpl(shipRepositoryPort),
                new DeleteShipUseCaseImpl(shipRepositoryPort),
                new UpdateShipUseCaseImpl(shipRepositoryPort),
                new RetrieveShipUseCaseImpl(shipRepositoryPort)
        );
    }

    @Bean
    public DockRepositoryPort dockRepositoryPort(JPARepositoryAdapter jpaRepositoryAdapter){
        return jpaRepositoryAdapter;
    }

    @Bean
    public ShipRepositoryPort shipRepositoryPort(JPARepositoryAdapter jpaRepositoryAdapter){
        return jpaRepositoryAdapter;
    }
}
