package cz.muni.fi.pa165.api.dto.weapon;

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
}
