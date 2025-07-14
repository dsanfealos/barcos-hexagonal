package sanfe.barcos_hexagonal.infrastructure.mappers;

import sanfe.barcos_hexagonal.domain.models.Dock;
import sanfe.barcos_hexagonal.domain.models.Ship;
import sanfe.barcos_hexagonal.infrastructure.entities.DockEntity;
import sanfe.barcos_hexagonal.infrastructure.entities.ShipEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

        List<ShipEntity> shipEntities = new ArrayList<>();
        if (dock.getShips() != null && !dock.getShips().isEmpty()){
            shipEntities = dock.getShips().stream()
                    .map(ship -> ShipMapper.fromDomainModel(ship, dockEntity))
                    .toList();
            dockEntity.setShips(shipEntities);
        }
        return dockEntity; //Para evitar tocar las relaciones de otros barcos con el muelle
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


        return dock;   //Para evitar problemas de nullPointerException en dominio
    }
}
