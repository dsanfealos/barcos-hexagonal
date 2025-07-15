package sanfe.spring_ships_hexagonal.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sanfe.spring_ships_hexagonal.application.services.DockService;
import sanfe.spring_ships_hexagonal.application.services.ShipService;
import sanfe.spring_ships_hexagonal.domain.models.Dock;
import sanfe.spring_ships_hexagonal.domain.models.Ship;
import sanfe.spring_ships_hexagonal.infrastructure.dto.DockDto;
import sanfe.spring_ships_hexagonal.infrastructure.mappers.DockMapper;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dock")
public class DockController {

    private final DockService dockService;
    private final ShipService shipService;

    public DockController(DockService dockService, ShipService shipService) {
        this.dockService = dockService;
        this.shipService = shipService;
    }

    @PostMapping("/")
    public ResponseEntity<DockDto> createDock(@RequestBody Dock body){
        Dock dock = dockService.createDock(body);
        return new ResponseEntity<>(DockMapper.domainToDto(dock), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<DockDto>> getAllDocks(){
        List<Dock> list = dockService.getAllDocks();
        return new ResponseEntity<>(list.stream()
                .map(DockMapper::domainToDto)
                .toList(), HttpStatus.OK);
    }

    @GetMapping("/{dockId}")
    public ResponseEntity<DockDto> getDock(@PathVariable Long dockId){
        Optional<Dock> dock = dockService.getDock(dockId);
        if (!dock.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(DockMapper.domainToDto(dock.get()), HttpStatus.OK);
    }

    @DeleteMapping("/{dockId}")
    public ResponseEntity<Void> deleteDock(@PathVariable Long dockId){
        if (dockService.deleteDock(dockId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<DockDto> updateDock(@RequestBody DockDto body){
        List<Ship> ships;
        try {
            ships = body.getShipsId().stream()
                    .map(id -> shipService.getShip(id).get())
                    .toList();
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Dock dockBody = new Dock(
                body.getId(),
                body.getName(),
                body.getLocation(),
                body.getCapacity(),
                body.getOcuppiedCapacity(),
                ships

        );

        Optional<Dock> dock = dockService.updateDock(dockBody);
        return dock.map(value -> new ResponseEntity<>(DockMapper.domainToDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
