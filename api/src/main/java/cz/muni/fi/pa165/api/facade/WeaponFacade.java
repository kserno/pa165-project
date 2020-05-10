package cz.muni.fi.pa165.api.facade;

import cz.muni.fi.pa165.api.dto.weapon.*;

import java.util.List;

/**
 * Facade weapon operations
 *
 * @author Filip Sollar
 */
public interface WeaponFacade {
    /**
     * Creates weapon
     * @param weaponCreateDTO - DTO representing new weapon
     * @return id of created entity
     */
    Long createWeapon(WeaponCreateDTO weaponCreateDTO);

    /**
     * Updates weapon with new data
     * @param weaponUpdateDTO - DTO representing new data
     */
    void updateWeapon(WeaponUpdateDTO weaponUpdateDTO);

    /**
     * Deletes weapon
     * @param id - id of weapon
     */
    void deleteWeapon(Long id);

    /**
     * Returns all weapons in form of {@link WeaponListDTO}
     *
     * @return weapons in form of {@link WeaponListDTO}
     */
    List<WeaponListDTO> getAllWeapons();

    /**
     * Returns weapon if form of {@link WeaponDTO}
     *
     * @param id - id of weapon
     * @return Weapon with specified id
     */
    WeaponDTO getWeaponById(Long id);

    /**
     * Adds effectiveness to weapon
     * @param weaponId - id of weapon
     * @param weaponEffectivenessCreateDTO - DTO representing weapon effectiveness
     */
    void addWeaponEffectiveness(Long weaponId, WeaponEffectivenessCreateDTO weaponEffectivenessCreateDTO);

    /**
     * Removes weapon effectiveness
     *
     * @param weaponId - id of weapon
     * @param effectivenessId - id of effectiveness
     */
    void removeWeaponEffectiveness(Long weaponId, Long effectivenessId);

}
