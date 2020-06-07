package cz.muni.fi.pa165.api.dto.weapon;

import java.util.Objects;

/**
 * @author Filip Sollar
 */
public class WeaponEffectivenessCreateDTO {

    private Long creatureId;
    private Long userId;
    private double rating;

    public Long getCreatureId() {
        return creatureId;
    }

    public void setCreatureId(Long creatureId) {
        this.creatureId = creatureId;
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
        WeaponEffectivenessCreateDTO that = (WeaponEffectivenessCreateDTO) o;
        return Double.compare(that.rating, rating) == 0 &&
                Objects.equals(creatureId, that.creatureId) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creatureId, userId, rating);
    }
}
