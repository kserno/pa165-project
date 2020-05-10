package cz.muni.fi.pa165.entity;

import cz.muni.fi.pa165.dao.effectiveness.EffectivenessDao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Entity representing an area, where can {@link Creature} creatures be spotted.
 *
 * @author Filip Sollar
 */
@Entity
@Table(name = "area")
public class Area {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    private String image;

    @ManyToMany(mappedBy = "areas")
    private List<Creature> creatures = new ArrayList<Creature>();

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatures(List<Creature> creatures) {
        this.creatures = creatures;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Creature> getCreatures() {
        return creatures;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return Objects.equals(id, area.id) &&
                Objects.equals(name, area.name) &&
                Objects.equals(description, area.description) &&
                Objects.equals(image, area.image) &&
                Objects.equals(creatures, area.creatures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, image, creatures);
    }
}
