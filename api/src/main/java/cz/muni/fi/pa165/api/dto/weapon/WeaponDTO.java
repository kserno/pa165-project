package cz.muni.fi.pa165.api.dto.weapon;

import cz.muni.fi.pa165.api.dto.effectiveness.EffectivenessDTO;
import cz.muni.fi.pa165.api.enums.AmmunitionType;

import java.util.List;
import java.util.Objects;

/**
 * @author Filip Sollar
 */
public class WeaponDTO {

    private Long id;

    private String name;
    private AmmunitionType ammunitionType;
    private double gunReach;

    private String image;

    private List<EffectivenessDTO> weaponEffectiveness;

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

    public List<EffectivenessDTO> getWeaponEffectiveness() {
        return weaponEffectiveness;
    }

    public void setWeaponEffectiveness(List<EffectivenessDTO> weaponEffectiveness) {
        this.weaponEffectiveness = weaponEffectiveness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeaponDTO weaponDTO = (WeaponDTO) o;
        return Double.compare(weaponDTO.gunReach, gunReach) == 0 &&
                Objects.equals(id, weaponDTO.id) &&
                Objects.equals(name, weaponDTO.name) &&
                ammunitionType == weaponDTO.ammunitionType &&
                Objects.equals(image, weaponDTO.image) &&
                Objects.equals(weaponEffectiveness, weaponDTO.weaponEffectiveness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ammunitionType, gunReach, image, weaponEffectiveness);
    }
}
