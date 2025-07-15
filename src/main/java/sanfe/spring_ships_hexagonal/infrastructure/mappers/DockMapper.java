package sanfe.spring_ships_hexagonal.infrastructure.mappers;

import sanfe.spring_ships_hexagonal.domain.models.Dock;
import sanfe.spring_ships_hexagonal.domain.models.Ship;
import sanfe.spring_ships_hexagonal.infrastructure.dto.DockDto;
import sanfe.spring_ships_hexagonal.infrastructure.entities.DockEntity;
import sanfe.spring_ships_hexagonal.infrastructure.entities.ShipEntity;

import java.util.Collections;
import java.util.List;

public class DockMapper {

    public static DockEntity fromDomainModel(Dock dock){
        DockEntity dockEntity = new DockEntity(
                dock.getId(),
                dock.getName(),
                dock.getLocation(),
                dock.getCapacity(),
                dock.getOcuppiedCapacity(),
                null
        );

        List<ShipEntity> shipEntities;
        if (dock.getShips() != null && !dock.getShips().isEmpty()){
            shipEntities = dock.getShips().stream()
                    .map(ship -> ShipMapper.fromDomainModel(ship, dockEntity))
                    .toList();
            dockEntity.setShips(shipEntities);
        }
        return dockEntity;
    }

    public static Dock toDomainModel(DockEntity dockEntity){
        Dock dock = new Dock(
                dockEntity.getId(),
                dockEntity.getName(),
                dockEntity.getLocation(),
                dockEntity.getCapacity(),
                dockEntity.getOcuppiedCapacity(),
                Collections.emptyList()
        );

        List<Ship> ships;
        if (dockEntity.getShips() != null && !dockEntity.getShips().isEmpty()){
            ships = dockEntity.getShips().stream()
                    .map(ship -> ShipMapper.toDomainModelWithDock(ship, dock))
                    .toList();
            dock.setShips(ships);
        }

        return dock;
    }

    public static DockDto domainToDto(Dock dock){
        return new DockDto(
                dock.getId(),
                dock.getName(),
                dock.getLocation(),
                dock.getCapacity(),
                dock.getOcuppiedCapacity(),
                dock.getShips().stream()
                        .map(Ship::getId)
                        .toList()
        );
    }
}
