package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.entity.Effectiveness;
import cz.muni.fi.pa165.entity.Weapon;

import java.util.List;

/**
 * Service for {@link Weapon}
 *
 * @author Filip Sollar
 */
public interface WeaponService {
    /**
     * Returns weapon with given id
     *
     * @param id - id of weapon
     * @return weapon with given id
     */
    Weapon getWeaponById(Long id);

    /**
     * Creates weapon
     *
     * @param weapon - weapon to be created
     */
    void createWeapon(Weapon weapon);

    /**
     * Updates weapon
     *
     * @param weapon - weapon to be updated
     */
    void updateWeapon(Weapon weapon);

    /**
     * Deletes weapon
     *
     * @param weapon - weapon to be deleted
     */
    void deleteWeapon(Weapon weapon);

    /**
     * Retrieves list of weapons
     *
     * @return list of weapons
     */
    List<Weapon> getAllWeapons();
}
