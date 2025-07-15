package sanfe.barcos_hexagonal.infrastructure.entities;

import jakarta.persistence.*;

@Entity
public class ShipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private DockEntity dockId;
    private Integer crewshipMembers;
    private String captain;

    public ShipEntity() {
    }

    public ShipEntity(Long id, String name, DockEntity dockId, Integer crewshipMembers, String captain) {
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

    public DockEntity getDockId() {
        return dockId;
    }

    public void setDockId(DockEntity dockId) {
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
