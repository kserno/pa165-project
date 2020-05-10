package cz.muni.fi.pa165.api.dto.effectiveness;

import cz.muni.fi.pa165.api.dto.creature.CreatureListDTO;
import cz.muni.fi.pa165.api.dto.user.UserListDTO;
import cz.muni.fi.pa165.api.dto.weapon.WeaponListDTO;

/**
 * @author Filip Sollar
 */
public class EffectivenessDTO {

    private CreatureListDTO creature;
    private WeaponListDTO weapon;
    private UserListDTO author;

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
}
