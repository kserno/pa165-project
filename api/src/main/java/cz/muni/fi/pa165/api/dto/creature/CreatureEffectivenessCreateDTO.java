package cz.muni.fi.pa165.api.dto.creature;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreatureEffectivenessCreateDTO that = (CreatureEffectivenessCreateDTO) o;
        return Double.compare(that.rating, rating) == 0 &&
                Objects.equals(weaponId, that.weaponId) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weaponId, userId, rating);
    }
}
