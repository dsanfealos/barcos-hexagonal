package sanfe.spring_ships_hexagonal.infrastructure.mappers;

import sanfe.spring_ships_hexagonal.domain.models.Dock;
import sanfe.spring_ships_hexagonal.domain.models.Ship;
import sanfe.spring_ships_hexagonal.infrastructure.dto.ShipDto;
import sanfe.spring_ships_hexagonal.infrastructure.entities.DockEntity;
import sanfe.spring_ships_hexagonal.infrastructure.entities.ShipEntity;

public class ShipMapper {

    public static ShipEntity fromDomainModel(Ship ship, DockEntity dockEntity){
        return new ShipEntity(
                ship.getId(),
                ship.getName(),
                dockEntity,
                ship.getCrewshipMembers(),
                ship.getCaptain()
        );
    }

    public static Ship toDomainModel(ShipEntity shipEntity){
        return new Ship(
                shipEntity.getId(),
                shipEntity.getName(),
                DockMapper.toDomainModel(shipEntity.getDockId()),
                shipEntity.getCrewshipMembers(),
                shipEntity.getCaptain()
        );
    }

    public static Ship toDomainModelWithDock(ShipEntity shipEntity, Dock dock){
        return new Ship(
                shipEntity.getId(),
                shipEntity.getName(),
                dock,
                shipEntity.getCrewshipMembers(),
                shipEntity.getCaptain()
        );
    }

    public static ShipDto domainToDto(Ship ship){
        return new ShipDto(
                ship.getId(),
                ship.getName(),
                ship.getDockId().getId(),
                ship.getCrewshipMembers(),
                ship.getCaptain()
                );
    }
}
