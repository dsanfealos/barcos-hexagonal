package sanfe.barcos_hexagonal.infrastructure.mappers;

import sanfe.barcos_hexagonal.domain.models.Dock;
import sanfe.barcos_hexagonal.infrastructure.entities.DockEntity;

import java.util.Collections;

public class DockMapper {

    public static DockEntity fromDomainModel(Dock dock){
        return new DockEntity(
                dock.getId(),
                dock.getName(),
                dock.getLocation(),
                dock.getCapacity(),
                dock.getOcuppiedCappacity(),
                null);  //Para evitar tocar las relaciones de otros barcos con el muelle
    }

    public static Dock toDomainModel(DockEntity dockEntity){
        return new Dock(dockEntity.getId(),
                dockEntity.getName(),
                dockEntity.getLocation(),
                dockEntity.getCapacity(),
                dockEntity.getOcuppiedCapacity(),
                Collections.emptyList());   //Para evitar problemas de nullPointerException en dominio
    }
}
