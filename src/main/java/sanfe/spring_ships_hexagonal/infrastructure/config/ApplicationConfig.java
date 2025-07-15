package sanfe.spring_ships_hexagonal.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sanfe.spring_ships_hexagonal.application.services.DockService;
import sanfe.spring_ships_hexagonal.application.services.ShipService;
import sanfe.spring_ships_hexagonal.application.usecasesimpl.*;
import sanfe.spring_ships_hexagonal.domain.ports.out.DockRepositoryPort;
import sanfe.spring_ships_hexagonal.domain.ports.out.ShipRepositoryPort;
import sanfe.spring_ships_hexagonal.infrastructure.adapters.JPARepositoryAdapter;

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
