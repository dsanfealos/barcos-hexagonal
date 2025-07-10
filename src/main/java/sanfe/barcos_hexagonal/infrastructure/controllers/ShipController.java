package sanfe.barcos_hexagonal.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sanfe.barcos_hexagonal.application.services.DockService;
import sanfe.barcos_hexagonal.application.services.ShipService;
import sanfe.barcos_hexagonal.domain.models.Dock;
import sanfe.barcos_hexagonal.domain.models.Ship;
import sanfe.barcos_hexagonal.infrastructure.dto.ShipDto;

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
    public ResponseEntity<Ship> createShip(@RequestBody ShipDto body){
        Optional<Dock> optionalDock = dockService.getDock(body.getDockId());
        if (optionalDock.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Ship ship = shipService.createShip(new Ship(null, body.getName(), optionalDock.get(),
                body.getCrewshipMembers(), body.getCaptain()));
        return new ResponseEntity<>(ship, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Ship>> getAllShips(){
        List<Ship> list = shipService.getAllShips();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
