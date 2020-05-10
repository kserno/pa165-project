package cz.muni.fi.pa165.api.dto.weapon;

import cz.muni.fi.pa165.api.enums.AmmunitionType;

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
}
