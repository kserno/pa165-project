package cz.muni.fi.pa165.api.dto.creature;

import cz.muni.fi.pa165.api.dto.area.AreaDTO;
import cz.muni.fi.pa165.api.dto.area.AreaListDTO;
import cz.muni.fi.pa165.api.dto.effectiveness.EffectivenessDTO;

import java.awt.geom.Area;
import java.util.List;
import java.util.Objects;

/**
 * @author Filip Sollar
 */
public class CreatureDTO {

    private Long id;
    private String name;

    private double weight;
    private double agility;
    private double height;

    private String image;

    private List<EffectivenessDTO> weaponEffectiveness;
    private List<AreaListDTO> areas;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<EffectivenessDTO> getWeaponEffectiveness() {
        return weaponEffectiveness;
    }

    public void setWeaponEffectiveness(List<EffectivenessDTO> weaponEffectiveness) {
        this.weaponEffectiveness = weaponEffectiveness;
    }

    public List<AreaListDTO> getAreas() {
        return areas;
    }

    public void setAreas(List<AreaListDTO> areas) {
        this.areas = areas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreatureDTO that = (CreatureDTO) o;
        return Double.compare(that.weight, weight) == 0 &&
                Double.compare(that.agility, agility) == 0 &&
                Double.compare(that.height, height) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(image, that.image) &&
                Objects.equals(weaponEffectiveness, that.weaponEffectiveness) &&
                Objects.equals(areas, that.areas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, weight, agility, height, image, weaponEffectiveness, areas);
    }
}
