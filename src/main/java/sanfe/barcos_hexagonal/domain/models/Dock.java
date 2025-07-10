package sanfe.barcos_hexagonal.domain.models;

import java.util.List;

public class Dock {
    private Long id;
    private String name;
    private String location;
    private Integer capacity;
    private Integer ocuppiedCapacity;
    private List<Ship> ships;

    public Dock(Long id, String name, String location, Integer capacity, Integer ocuppiedCapacity, List<Ship> ships) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.ocuppiedCapacity = ocuppiedCapacity;
        this.ships = ships;
    }

    public boolean isFull(){
        return ocuppiedCapacity >= capacity;
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

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }
}
