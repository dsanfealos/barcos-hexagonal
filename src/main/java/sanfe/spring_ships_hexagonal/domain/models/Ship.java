package sanfe.spring_ships_hexagonal.domain.models;

import sanfe.spring_ships_hexagonal.domain.common.ShipSizes;

public class Ship {

    private Long id;
    private String name;
    private Dock dockId;
    private Integer crewshipMembers;
    private String captain;

    public Ship(Long id, String name, Dock dockId, Integer crewshipMembers, String captain) {
        this.id = id;
        this.name = name;
        this.dockId = dockId;
        this.crewshipMembers = crewshipMembers;
        this.captain = captain;
    }

    public String howBig(){
        if(crewshipMembers < 5) return ShipSizes.SMALL.name();
        if(crewshipMembers < 10) return ShipSizes.REGULAR.name();
        if(crewshipMembers < 25) return ShipSizes.BIG.name();
        return ShipSizes.HUGE.name();
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

    public Dock getDockId() {
        return dockId;
    }

    public void setDockId(Dock dockId) {
        this.dockId = dockId;
    }

    public Integer getCrewshipMembers() {
        return crewshipMembers;
    }

    public void setCrewshipMembers(Integer crewshipMembers) {
        this.crewshipMembers = crewshipMembers;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }
}
