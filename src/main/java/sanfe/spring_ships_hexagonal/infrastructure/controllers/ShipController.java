package sanfe.spring_ships_hexagonal.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sanfe.spring_ships_hexagonal.application.services.DockService;
import sanfe.spring_ships_hexagonal.application.services.ShipService;
import sanfe.spring_ships_hexagonal.domain.models.Dock;
import sanfe.spring_ships_hexagonal.domain.models.Ship;
import sanfe.spring_ships_hexagonal.infrastructure.dto.ShipDto;
import sanfe.spring_ships_hexagonal.infrastructure.mappers.ShipMapper;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ship")
public class ShipController {

    private final ShipService shipService;
    private final DockService dockService;

    public ShipController(ShipService shipService, DockService dockService) {
        this.shipService = shipService;
        this.dockService = dockService;
    }

    @PostMapping
    public ResponseEntity<ShipDto> createShip(@RequestBody ShipDto body){
        Optional<Dock> optionalDock = dockService.getDock(body.getDockId());
        if (optionalDock.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Ship ship = shipService.createShip(new Ship(null, body.getName(), optionalDock.get(),
                body.getCrewshipMembers(), body.getCaptain()));
        return new ResponseEntity<>(ShipMapper.domainToDto(ship), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ShipDto>> getAllShips(){
        List<Ship> list = shipService.getAllShips();
        return new ResponseEntity<>(list.stream()
                .map(ShipMapper::domainToDto)
                .toList(), HttpStatus.OK);
    }

    @GetMapping("/{shipId}")
    public ResponseEntity<ShipDto> getShip(@PathVariable Long shipId){
        Optional<Ship> ship = shipService.getShip(shipId);
        if (ship.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(ShipMapper.domainToDto(ship.get()), HttpStatus.OK);
    }

    @DeleteMapping("/{shipId}")
    public ResponseEntity<Void> deleteShip(@PathVariable Long shipId){
        if (shipService.deleteShip(shipId)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<ShipDto> updateShip(@RequestBody ShipDto body){
        Optional<Dock> dock = dockService.getDock(body.getDockId());
        if (dock.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Ship shipBody = new Ship(
                body.getId(),
                body.getName(),
                dock.get(),
                body.getCrewshipMembers(),
                body.getCaptain()
        );

        Optional<Ship> ship = shipService.updateShip(shipBody);
        return ship.map(value -> new ResponseEntity<>(ShipMapper.domainToDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
