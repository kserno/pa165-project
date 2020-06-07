package cz.muni.fi.pa165.api.dto.weapon;

import cz.muni.fi.pa165.api.enums.AmmunitionType;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @author Filip Sollar
 */
public class WeaponCreateDTO {

    private double gunReach;

    @NotNull
    private String name;

    private String image;

    private AmmunitionType ammunitionType;

    public double getGunReach() {
        return gunReach;
    }

    public void setGunReach(double gunReach) {
        this.gunReach = gunReach;
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

    public AmmunitionType getAmmunitionType() {
        return ammunitionType;
    }

    public void setAmmunitionType(AmmunitionType ammunitionType) {
        this.ammunitionType = ammunitionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeaponCreateDTO that = (WeaponCreateDTO) o;
        return Double.compare(that.gunReach, gunReach) == 0 &&
                Objects.equals(name, that.name) &&
                Objects.equals(image, that.image) &&
                ammunitionType == that.ammunitionType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gunReach, name, image, ammunitionType);
    }
}
