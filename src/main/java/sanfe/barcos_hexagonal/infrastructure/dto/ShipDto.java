package sanfe.barcos_hexagonal.infrastructure.dto;

public class ShipDto {
    private String name;
    private Long DockId;
    private Integer crewshipMembers;
    private String captain;

    public ShipDto(String name, Long dockId, Integer crewshipMembers, String captain) {
        this.name = name;
        DockId = dockId;
        this.crewshipMembers = crewshipMembers;
        this.captain = captain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDockId() {
        return DockId;
    }

    public void setDockId(Long dockId) {
        DockId = dockId;
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
