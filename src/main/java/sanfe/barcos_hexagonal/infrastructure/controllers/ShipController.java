package sanfe.barcos_hexagonal.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sanfe.barcos_hexagonal.application.services.ShipService;
import sanfe.barcos_hexagonal.domain.models.Ship;

import java.util.List;

@RestController
@RequestMapping("/api/ship")
public class ShipController {

    private final ShipService shipService;

    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @PostMapping
    public ResponseEntity<Ship> createShip(@RequestBody Ship body){
        Ship ship = shipService.createShip(body);
        return new ResponseEntity<>(ship, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Ship>> getAllShips(){
        List<Ship> list = shipService.getAllShips();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
