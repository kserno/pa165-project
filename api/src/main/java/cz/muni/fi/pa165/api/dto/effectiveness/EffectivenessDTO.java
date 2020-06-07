package cz.muni.fi.pa165.api.dto.effectiveness;

import cz.muni.fi.pa165.api.dto.creature.CreatureListDTO;
import cz.muni.fi.pa165.api.dto.user.UserListDTO;
import cz.muni.fi.pa165.api.dto.weapon.WeaponListDTO;

import java.util.Objects;

/**
 * @author Filip Sollar
 */
public class EffectivenessDTO {

    private Long id;
    private CreatureListDTO creature;
    private WeaponListDTO weapon;
    private UserListDTO author;
    private double rating;

    public Long getId() {
        return id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CreatureListDTO getCreature() {
        return creature;
    }

    public void setCreature(CreatureListDTO creature) {
        this.creature = creature;
    }

    public WeaponListDTO getWeapon() {
        return weapon;
    }

    public void setWeapon(WeaponListDTO weapon) {
        this.weapon = weapon;
    }

    public UserListDTO getAuthor() {
        return author;
    }

    public void setAuthor(UserListDTO author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EffectivenessDTO that = (EffectivenessDTO) o;
        return Double.compare(that.rating, rating) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(creature, that.creature) &&
                Objects.equals(weapon, that.weapon) &&
                Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creature, weapon, author, rating);
    }
}
