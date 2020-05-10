package cz.muni.fi.pa165.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Entity representing mutants or zombie objects
 *
 * @author Filip Sollar
 */
@Entity
@Table(name = "creature")
public class Creature {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;


    private double weight;

    private double agility;

    private double height;

    private String image;

    @OneToMany
    private List<Effectiveness> weaponEffectiveness = new ArrayList<Effectiveness>();

    @ManyToMany
    @JoinTable(
            name = "creature_area",
            joinColumns = @JoinColumn(name = "creature_id"),
            inverseJoinColumns = @JoinColumn(name = "area_id")
    )
    private List<Area> areas = new ArrayList<Area>();

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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getAgility() {
        return agility;
    }

    public void setAgility(double agility) {
        this.agility = agility;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public List<Effectiveness> getWeaponEffectiveness() {
        return weaponEffectiveness;
    }

    public void setWeaponEffectiveness(List<Effectiveness> weaponEffectiveness) {
        this.weaponEffectiveness = weaponEffectiveness;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
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
        Creature creature = (Creature) o;
        return Double.compare(creature.weight, weight) == 0 &&
                Double.compare(creature.agility, agility) == 0 &&
                Double.compare(creature.height, height) == 0 &&
                Objects.equals(id, creature.id) &&
                Objects.equals(name, creature.name) &&
                Objects.equals(image, creature.image) &&
                Objects.equals(weaponEffectiveness, creature.weaponEffectiveness) &&
                Objects.equals(areas, creature.areas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, weight, agility, height, image, weaponEffectiveness, areas);
    }
}
