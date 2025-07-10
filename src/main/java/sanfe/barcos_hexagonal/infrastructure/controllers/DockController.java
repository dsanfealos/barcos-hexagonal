package sanfe.barcos_hexagonal.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sanfe.barcos_hexagonal.application.services.DockService;
import sanfe.barcos_hexagonal.domain.models.Dock;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api/dock")
public class DockController {

    private final DockService dockService;

    public DockController(DockService dockService) {
        this.dockService = dockService;
    }

    @PostMapping("/")
    public ResponseEntity<Dock> createDock(@RequestBody Dock body){
        Dock dock = dockService.createDock(body);
        return new ResponseEntity<>(dock, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Dock>> getAllDocks(){
        List<Dock> list = dockService.getAllDocks();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
