package cz.muni.fi.pa165.api.dto.area;

import cz.muni.fi.pa165.api.dto.creature.CreatureDTO;

import java.util.List;

/**
 * @author Filip Sollar
 */
public class AreaDTO {

    private Long id;
    private String name;
    private String description;
    private String image;
    private List<CreatureDTO> creatures;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<CreatureDTO> getCreatures() {
        return creatures;
    }

    public void setCreatures(List<CreatureDTO> creatures) {
        this.creatures = creatures;
    }
}
