package cz.muni.fi.pa165.api.dto.creature;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @author Filip Sollar
 */
public class CreatureUpdateDTO {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    private double weight;
    private double agility;
    private double height;

    private String image;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreatureUpdateDTO that = (CreatureUpdateDTO) o;
        return Double.compare(that.weight, weight) == 0 &&
                Double.compare(that.agility, agility) == 0 &&
                Double.compare(that.height, height) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, weight, agility, height, image);
    }
}
