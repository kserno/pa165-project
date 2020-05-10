package cz.muni.fi.pa165.api.dto.creature;

/**
 * @author Filip Sollar
 */
public class CreatureEffectivenessCreateDTO {

    private Long weaponId;
    private Long userId;
    private double rating;

    public Long getWeaponId() {
        return weaponId;
    }

    public void setWeaponId(Long weaponId) {
        this.weaponId = weaponId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
