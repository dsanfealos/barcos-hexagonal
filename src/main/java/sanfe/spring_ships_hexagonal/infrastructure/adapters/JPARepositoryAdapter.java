package sanfe.spring_ships_hexagonal.infrastructure.adapters;

import org.springframework.stereotype.Component;
import sanfe.spring_ships_hexagonal.domain.models.Dock;
import sanfe.spring_ships_hexagonal.domain.models.Ship;
import sanfe.spring_ships_hexagonal.domain.ports.out.DockRepositoryPort;
import sanfe.spring_ships_hexagonal.domain.ports.out.ShipRepositoryPort;
import sanfe.spring_ships_hexagonal.infrastructure.entities.DockEntity;
import sanfe.spring_ships_hexagonal.infrastructure.entities.ShipEntity;
import sanfe.spring_ships_hexagonal.infrastructure.mappers.DockMapper;
import sanfe.spring_ships_hexagonal.infrastructure.mappers.ShipMapper;
import sanfe.spring_ships_hexagonal.infrastructure.repositories.JPADockRepository;
import sanfe.spring_ships_hexagonal.infrastructure.repositories.JPAShipRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JPARepositoryAdapter implements DockRepositoryPort, ShipRepositoryPort {

    private final JPAShipRepository jpaShipRepository;
    private final JPADockRepository jpaDockRepository;

    public JPARepositoryAdapter(JPAShipRepository jpaShipRepository, JPADockRepository jpaDockRepository) {
        this.jpaShipRepository = jpaShipRepository;
        this.jpaDockRepository = jpaDockRepository;
    }

    @Override
    public Dock save(Dock dock) {
        DockEntity entity = DockMapper.fromDomainModel(dock);
        DockEntity savedEntity = jpaDockRepository.save(entity);

        return DockMapper.toDomainModel(savedEntity);
    }

    @Override
    public Ship save(Ship ship) {
        Dock dock = findDockById(ship.getDockId().getId()).get();
        DockEntity dockEntity = DockMapper.fromDomainModel(dock);
        ShipEntity entity = ShipMapper.fromDomainModel(ship, dockEntity);
        ShipEntity savedEntity = jpaShipRepository.save(entity);

        return ShipMapper.toDomainModel(savedEntity);
    }

    @Override
    public boolean deleteDockById(Long id) {
        if (jpaDockRepository.existsById(id)){
            jpaDockRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteShipById(Long id) {
        if (jpaShipRepository.existsById(id)){
            jpaShipRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Dock> findDockById(Long id) {
        return jpaDockRepository.findById(id).map(DockMapper::toDomainModel);
    }

    @Override
    public Optional<Ship> findShipById(Long id) {
        return jpaShipRepository.findById(id).map(ShipMapper::toDomainModel);
    }

    @Override
    public List<Dock> findAllDocks() {
        return jpaDockRepository.findAll().stream()
                .map(DockMapper::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<Ship> findAllShips() {
        return jpaShipRepository.findAll().stream()
                .map(ShipMapper::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Ship> update(Ship ship) {
        if (jpaShipRepository.existsById(ship.getId())){
            Dock dock = findDockById(ship.getDockId().getId()).get();
            DockEntity dockEntity = DockMapper.fromDomainModel(dock);
            ShipEntity entity = ShipMapper.fromDomainModel(ship, dockEntity);
            ShipEntity updatedEntity = jpaShipRepository.save(entity);

            return Optional.of(ShipMapper.toDomainModel(updatedEntity));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Dock> update(Dock dock) {
        if (jpaDockRepository.existsById(dock.getId())){
            DockEntity entity = DockMapper.fromDomainModel(dock);
            DockEntity updatedEntity = jpaDockRepository.save(entity);
            return Optional.of(DockMapper.toDomainModel(updatedEntity));
        }
        return Optional.empty();
    }
}
