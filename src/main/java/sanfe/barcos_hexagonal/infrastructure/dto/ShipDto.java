package sanfe.barcos_hexagonal.infrastructure.dto;

public class ShipDto {

    private Long id;
    private String name;
    private Long dockId;
    private Integer crewshipMembers;
    private String captain;

    public ShipDto(Long id, String name, Long dockId, Integer crewshipMembers, String captain) {
        this.id = id;
        this.name = name;
        this.dockId = dockId;
        this.crewshipMembers = crewshipMembers;
        this.captain = captain;
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

    public Long getDockId() {
        return dockId;
    }

    public void setDockId(Long dockId) {
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
