package sanfe.barcos_hexagonal.infrastructure.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sanfe.barcos_hexagonal.application.services.DockService;

@RestController
@RequestMapping("/api/dock")
public class DockController {

    private final DockService dockService;

    public DockController(DockService dockService) {
        this.dockService = dockService;
    }
}
