package sanfe.spring_ships_hexagonal.infrastructure.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class DockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private Integer capacity;
    private Integer ocuppiedCapacity;
    @OneToMany(mappedBy = "dockId", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ShipEntity> ships;

    public DockEntity() {
    }

    public DockEntity(Long id, String name, String location, Integer capacity, Integer ocuppiedCapacity, List<ShipEntity> ships) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.ocuppiedCapacity = ocuppiedCapacity;
        this.ships = ships;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getOcuppiedCapacity() {
        return ocuppiedCapacity;
    }

    public void setOcuppiedCapacity(Integer ocuppiedCapacity) {
        this.ocuppiedCapacity = ocuppiedCapacity;
    }

    public List<ShipEntity> getShips() {
        return ships;
    }

    public void setShips(List<ShipEntity> ships) {
        this.ships = ships;
    }
}
