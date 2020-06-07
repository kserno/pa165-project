package cz.muni.fi.pa165.api.dto.weapon;

import cz.muni.fi.pa165.api.enums.AmmunitionType;

import java.util.Objects;

/**
 * @author Filip Sollar
 */
public class WeaponListDTO {

    private Long id;

    private String name;
    private AmmunitionType ammunitionType;
    private double gunReach;

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

    public AmmunitionType getAmmunitionType() {
        return ammunitionType;
    }

    public void setAmmunitionType(AmmunitionType ammunitionType) {
        this.ammunitionType = ammunitionType;
    }

    public double getGunReach() {
        return gunReach;
    }

    public void setGunReach(double gunReach) {
        this.gunReach = gunReach;
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
        WeaponListDTO that = (WeaponListDTO) o;
        return Double.compare(that.gunReach, gunReach) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                ammunitionType == that.ammunitionType &&
                Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ammunitionType, gunReach, image);
    }
}
