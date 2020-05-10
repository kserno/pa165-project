package cz.muni.fi.pa165.entity;

import cz.muni.fi.pa165.enums.AmmunitionType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Entity representing weapon that exists in our fictional world.
 *
 * @author Filip Sollar
 */
@Entity
@Table(name = "weapon")
public class Weapon {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private double gunReach;

    @NotNull
    private String name;

    private String image;

    @Enumerated
    @NotNull
    private AmmunitionType ammunitionType;

    @OneToMany
    private List<Effectiveness> weaponEffectiveness = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getGunReach() {
        return gunReach;
    }

    public void setGunReach(double gunReach) {
        this.gunReach = gunReach;
    }

    public AmmunitionType getAmmunitionType() {
        return ammunitionType;
    }

    public void setAmmunitionType(AmmunitionType ammunitionType) {
        this.ammunitionType = ammunitionType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Effectiveness> getWeaponEffectiveness() {
        return weaponEffectiveness;
    }

    public void setWeaponEffectiveness(List<Effectiveness> weaponEffectiveness) {
        this.weaponEffectiveness = weaponEffectiveness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weapon weapon = (Weapon) o;
        return Double.compare(weapon.gunReach, gunReach) == 0 &&
                Objects.equals(id, weapon.id) &&
                Objects.equals(name, weapon.name) &&
                Objects.equals(image, weapon.image) &&
                ammunitionType == weapon.ammunitionType &&
                Objects.equals(weaponEffectiveness, weapon.weaponEffectiveness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gunReach, name, image, ammunitionType, weaponEffectiveness);
    }
}
